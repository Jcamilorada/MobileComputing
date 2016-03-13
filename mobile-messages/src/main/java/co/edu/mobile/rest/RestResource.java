package co.edu.mobile.rest;

import co.edu.mobile.domain.Message;
import co.edu.mobile.domain.SharedFile;
import co.edu.mobile.domain.User;
import co.edu.mobile.persistence.IFilesRepository;
import co.edu.mobile.persistence.IMessagesRepository;
import co.edu.mobile.persistence.IUsersReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rest")
public class RestResource
{
    @Autowired
    private IUsersReporsitory usersReporsitory;

    @Autowired
    private IMessagesRepository messagesRepository;

    @Autowired
    private IFilesRepository filesRepository;

    @RequestMapping("/version")
    public String getVersion()
    {
        return "1.0.0";
    }

    @RequestMapping("/contacts/{userId}")
    public List<User> getContactos(@PathVariable long userId)
    {
        User user = usersReporsitory.findOne(userId);
        List<Long> contactsId = user.getContacts().stream().map(p -> p.getUserId()).collect(Collectors.toList());

        return usersReporsitory.findAll(contactsId);
    }

    @RequestMapping("/messages/{fromUserId}/{toUserId}")
    public List<Message> getMensajes(@PathVariable long fromUserId, @PathVariable long toUserId)
    {
        List<Message> messages = messagesRepository.findByUsers(fromUserId, toUserId);
        messagesRepository.deleteInBatch(messages);

        return messages;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public void newMessage(@RequestBody Message message)
    {
        message.setDate(new Date());
        messagesRepository.save(message);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/files/{fromUserId}/{toUserId}")
    public SharedFile uploadFile(
        @PathVariable long fromUserId, @PathVariable long toUserId, @RequestParam("file") MultipartFile file) throws IOException
    {
        SharedFile sharedFile = new SharedFile();
        sharedFile.setFrom(fromUserId);
        sharedFile.setTo(toUserId);
        sharedFile.setName(file.getOriginalFilename());
        sharedFile.setContentType(file.getContentType());
        sharedFile.setData(file.getBytes());
        sharedFile.setDate(new Date());
        filesRepository.save(sharedFile);

        return sharedFile;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/shared_files/{fromUserId}/{toUserId}")
    public List<SharedFile> getSharedFiles(
        @PathVariable long fromUserId, @PathVariable long toUserId) throws IOException
    {
        List<SharedFile> files = filesRepository.findByUsers(fromUserId, toUserId);

        return files;
    }

    @RequestMapping(value = "/files/{file_id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getFile(@PathVariable long file_id)
    {
        SharedFile sharedFile = filesRepository.findOne(file_id);

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition", "attachment; filename=" + sharedFile.getName().replace(" ", "_"));
        header.setContentLength(sharedFile.getData().length);

        return new HttpEntity<>(sharedFile.getData(), header);
    }
}

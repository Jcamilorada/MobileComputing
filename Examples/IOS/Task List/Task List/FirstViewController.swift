//
//  ViewController.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/3/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet weak var tableView: UITableView!
    private var taskManager = TaskManager()
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return taskManager.count()
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:CustomTableViewCell = tableView.dequeueReusableCellWithIdentifier("CustomCell") as! CustomTableViewCell
        let task = taskManager.getTask(indexPath.row)
        cell.nameLabel!.text = task.name
        cell.descriptionLabel!.text = task.desc
        return cell
    }
    
    func tableView(tableView: UITableView, commitEditingStyle editingStyle: UITableViewCellEditingStyle, forRowAtIndexPath indexPath: NSIndexPath) {
        if editingStyle == UITableViewCellEditingStyle.Delete{
            taskManager.removeTask(indexPath.row)
            tableView.reloadData()
        }
    }
    
    override func viewWillAppear(animated: Bool) {
        tableView.reloadData()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}


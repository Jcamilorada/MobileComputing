//
//  SecondViewController.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/3/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//
import UIKit

class SecondViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var desTextField: UITextField!
    private var taskManager = TaskManager()
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func addTask(sender: UIButton) {
        taskManager.addTask(nameTextField.text!, desc: desTextField.text!)
        nameTextField.text = ""
        desTextField.text = ""
        self.view.endEditing(true)
        self.tabBarController!.selectedIndex = 0;
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        self.view.endEditing(true)
    }
}

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
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func addTask(sender: UIButton) {
        TaskManager.addTask(nameTextField.text!, desc: desTextField.text!)
        self.view.endEditing(true)
        nameTextField.text = ""
        desTextField.text = ""
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

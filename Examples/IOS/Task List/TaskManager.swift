//
//  TaskManager.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/3/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//

import UIKit

class TaskManager: NSObject {
    static var tasks = [Task]()
    
    static func addTask(name:String, desc:String) {
        let task = Task(name:name, desc:desc)
        tasks.append(task)
    }
    
    static func removeTask(index:Int)
    {
        tasks.removeAtIndex(index)
    }

    
}

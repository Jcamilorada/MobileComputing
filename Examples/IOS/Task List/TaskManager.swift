//
//  TaskManager.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/3/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//

import UIKit
import SQLite

class TaskManager {

    private var db:Connection
    
    private var tasks:Table
    private var nameColumn:Expression<String>
    private var descriptionColumn:Expression<String>
    private var idColumn:Expression<Int>

    init(){
        let path = NSSearchPathForDirectoriesInDomains(.DocumentDirectory, .UserDomainMask, true).first!
        
        db = try! Connection("\(path)/db.sqlite3")
        
        tasks = Table("task")
        idColumn = Expression<Int>("id")
        nameColumn = Expression<String>("name")
        descriptionColumn = Expression<String>("description")
        
        //try! db.run(tasks.drop(ifExists: true))
        try! db.run(tasks.create(ifNotExists: true) { t in
            t.column(idColumn, primaryKey: PrimaryKey.Autoincrement)
            t.column(nameColumn)
            t.column(descriptionColumn)
        })
    }
    
    func addTask(name:String, desc:String) {
        try! db.run(tasks.insert(nameColumn <- name, descriptionColumn <- desc))
    }
    
    func getTask(id:Int) -> Task{
        let query = tasks.limit(1, offset: id)
        let task = Array(try! db.prepare(query))[0]
        
        return Task(name: task.get(nameColumn) , desc: task.get(descriptionColumn));
    }
    
    func removeTask(id:Int) {
        let query = tasks.limit(1, offset: id)
        let task = Array(try! db.prepare(query))[0]
    
        try! db.run(tasks.filter(idColumn == task.get(idColumn)).delete())
    }
    
    func count() -> Int {
        return db.scalar(tasks.count)
    }
    
}

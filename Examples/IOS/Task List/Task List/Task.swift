//
//  Task.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/3/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//

import UIKit

class Task: NSObject {
    let name:String
    let desc:String
    
    init(name:String, desc:String) {
        self.name = name
        self.desc = desc
    }
}

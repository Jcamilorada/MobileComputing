//
//  CustomTableViewCell.swift
//  Task List
//
//  Created by JUAN CAMILO RADA on 5/26/16.
//  Copyright © 2016 JUAN CAMILO RADA. All rights reserved.
//

import UIKit

class CustomTableViewCell: UITableViewCell {

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }

}

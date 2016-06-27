/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fonzi
 * Created: 24.06.2016
 */

CREATE TABLE `benutzer` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `nachweis` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`nr` int(11) DEFAULT NULL,
`benutzer_id` int(11) NOT NULL,
`datum` DATE,
PRIMARY KEY (`id`),
FOREIGN KEY (`benutzer_id`) REFERENCES `benutzer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `bericht` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`dokumentation` varchar(1024) DEFAULT NULL,
`zeit` TIME,
`nachweis_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`nachweis_id`) REFERENCES `nachweis` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


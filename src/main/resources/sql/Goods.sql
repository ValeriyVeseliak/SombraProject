INSERT INTO `sombrastore`.`cathegory` (`id`, `cathName`) VALUES ('1', 'Bikes');
INSERT INTO `sombrastore`.`cathegory` (`id`, `cathName`) VALUES ('2', 'Bicycles');
INSERT INTO `sombrastore`.`cathegory` (`id`, `cathName`) VALUES ('3', 'Cars');
INSERT INTO `sombrastore`.`cathegory` (`id`, `cathName`) VALUES ('4', 'Trains');



INSERT INTO `sombrastore`.`good` (`id`, `description`, `goodName`, `price`, `cathegoryId`) VALUES ('1', 'SuperCar', 'Bentli', '1500', '3');
INSERT INTO `sombrastore`.`good` (`id`, `description`, `goodName`, `price`, `cathegoryId`) VALUES ('2', 'Cool train', 'Train', '200', '4');
INSERT INTO `sombrastore`.`good` (`id`, `description`, `goodName`, `price`, `cathegoryId`) VALUES ('3', 'Ghost', 'Bike ghost', '400', '1');


UPDATE `sombrastore`.`good` SET `isAvailable`=1 WHERE `id`='1';
UPDATE `sombrastore`.`good` SET `isAvailable`=1 WHERE `id`='2';
UPDATE `sombrastore`.`good` SET `isAvailable`=1 WHERE `id`='3';
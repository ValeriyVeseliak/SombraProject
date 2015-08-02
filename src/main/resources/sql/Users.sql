
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('1', 'admin@admin.admin', 'ADMIN', 'ADMIN', 'Admin', 'admin', 'ROLE_ADMIN');
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('2', 'mail@mail.mail', 'John', 'Malkovich', '123456', 'qwerty', 'ROLE_USER');
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('3', 'email@email.email', 'Lucy', 'Novick', 'qwerty', 'qwerty', 'ROLE_USER');

UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='4536456' WHERE `id`='1';
UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='456456' WHERE `id`='2';
UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='4564855' WHERE `id`='3';

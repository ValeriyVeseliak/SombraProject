
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('1', 'admin@admin.admin', 'ADMIN', 'ADMIN', 'Admin', '$2a$12$Lv76fLbKB8JmcKowsyifi.cIDzS6udK2R.A4unNn7Z.bUBW5XR9V2', 'ROLE_ADMIN');
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('2', 'mail@mail.mail', 'John', 'Malkovich', '123456', '$2a$12$MtBiWbZ5rr0eCT9qCLdpQO8SrgZT1aiLtEuX7u4Jo.3m03T0GGxhu', 'ROLE_USER');
INSERT INTO `sombrastore`.`user` (`id`, `email`, `firstName`, `lastName`, `login`, `password`, `role`) VALUES ('3', 'email@email.email', 'Lucy', 'Novick', 'qwerty', '$2a$12$R7/2vlhRxWKJo.mujtSbruF7wA4yM5yEgmAnJ0KoC0ijlWkbWwyi6', 'ROLE_USER');

UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='4536456' WHERE `id`='1';
UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='456456' WHERE `id`='2';
UPDATE `sombrastore`.`user` SET `isEnabled`=1, `phoneNumber`='4564855' WHERE `id`='3';

CREATE SCHEMA `basic`;

CREATE TABLE `basic`.`user`
(
    `id`           VARCHAR(10) NOT NULL,
    `password`     VARCHAR(10) NOT NULL,
    `nickname`     VARCHAR(10) NULL,
    `registerDate` DATETIME    NULL DEFAULT NOW(),
    CONSTRAINT PRIMARY KEY (`id`)
);

DROP TABLE `basic`.`user`;
delete from userplant;
delete from user;
delete from plant;

INSERT INTO user VALUES (1,'Kue','Xiong','kxiong'),
                        (2, 'Spongebob', 'Square Pants', 'ssquarepants');

INSERT INTO plant VALUES (1, 3),
                         (2, 6);

INSERT INTO userplant VALUES (1, 1, 2),
                             (2, 1, 1),
                             (3, 2, 1);
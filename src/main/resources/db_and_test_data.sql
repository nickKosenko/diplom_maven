create table group_id
(
    id   integer primary key autoincrement,
    name text unique
);

insert into group_id(name)
values ('KND-11'),
       ('SAD-21'),
       ('KID-15');



create table basic_hours
(
    lecture    integer,
    practice   integer,
    laboratory integer,
    sum        integer,
    group_id   integer,

    foreign key (group_id) references group_id (id)
);

insert into basic_hours(lecture, practice, laboratory, sum, group_id)
values (25, 15, 0, 40, 1),
       (30, 10, 5, 45, 2),
       (40, 10, 10, 60, 3);



create table students
(
    id          integer primary key autoincrement,
    group_id    integer,
    name        text,
    second_name text,
    third_name  text,
    initials    text,
    card_number text,

    foreign key (group_id) references group_id (id)
);

insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Saraann',        'Hattam',              'shattam0',                'Saraann H.S.',                            '374622478115347',           1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Kelcey',         'Bridden',             'kbridden1',               'Kelcey B.K.',                            '374288713374402',            1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Dina',           'Vase',                'dvase2',                  'Dina V.D.',                            '372301084642851',              1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Giacopo',        'Pickering',           'gpickering3',             'Giacopo P.G.',                            '337941939073796',           1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Giles',          'Baum',                'gbaum4',                  'Giles B.G.',                            '374283124139130',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Lorry',          'Heaselgrave',         'lheaselgrave5',           'Lorry H.L.',                            '372301704422510',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Philippa',       'Collett',             'pcollett6',               'Philippa C.P.',                            '374288880248850',          1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Hanni',          'Biddlestone',         'hbiddlestone7',           'Hanni B.H.',                            '337941957315277',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Chrissy',        'Sanford',             'csanford8',               'Chrissy S.C.',                            '342095358417902',           1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Burk',           'Painter',             'bpainter9',               'Burk P.B.',                            '337941449529717',              1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Fletcher',       'Vials',               'fvialsa',                 'Fletcher V.F.',                            '349095536382237',          1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Annice',         'Towson',              'atowsonb',                'Annice T.A.',                            '375341795077051',            1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Rowe',           'Krojn',               'rkrojnc',                 'Rowe K.R.',                            '348256244104054',              1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Paige',          'Oakey',               'poakeyd',                 'Paige O.P.',                            '374283530733377',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Sibyl',          'Rutigliano',          'srutiglianoe',            'Sibyl R.S.',                            '374288036622370',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Derrick',        'Higgen',              'dhiggenf',                'Derrick H.D.',                            '378412264733123',           1              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Mignon',         'Earsman',             'mearsmang',               'Mignon E.M.',                            '374622363965012',            1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Rolfe',          'Sturgis',             'rsturgish',               'Rolfe S.R.',                            '374283038154100',             1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Cornie',         'Ingerfield',          'cingerfieldi',            'Cornie I.C.',                            '372301808027934',            1          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Paulette',       'Arnaudin',            'parnaudinj',              'Paulette A.P.',                            '337941015988685',          2              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Shana',          'Strathern',           'sstrathernk',             'Shana S.S.',                            '370358392596148',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Graeme',         'Elphinston',          'gelphinstonl',            'Graeme E.G.',                            '377446339365348',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Maia',           'Egdal',               'megdalm',                 'Maia E.M.',                            '345219135086155',              2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Mikel',          'Jearum',              'mjearumn',                'Mikel J.M.',                            '374283987532652',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Zorina',         'Boulstridge',         'zboulstridgeo',           'Zorina B.Z.',                            '371715701399697',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Manolo',         'Ferraraccio',         'mferraracciop',           'Manolo F.M.',                            '374288332879526',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Idette',         'McGennis',            'imcgennisq',              'Idette M.I.',                            '337941478250839',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Justinn',        'Forge',               'jforger',                 'Justinn F.J.',                            '374288758091937',           2              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Lidia',          'Elener',              'leleners',                'Lidia E.L.',                            '373823688129182',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Arthur',         'Switland',            'aswitlandt',              'Arthur S.A.',                            '374283304487945',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Beale',          'Cancutt',             'bcancuttu',               'Beale C.B.',                            '372301871703684',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Cyndi',          'Pattington',          'cpattingtonv',            'Cyndi P.C.',                            '374288162193808',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Ronnie',         'Cossar',              'rcossarw',                'Ronnie C.R.',                            '337941187420376',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Olivie',         'Gouldeby',            'ogouldebyx',              'Olivie G.O.',                            '372301997371143',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Luci',           'Messer',              'lmessery',                'Luci M.L.',                            '372301125089997',              2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Nady',           'Tubritt',             'ntubrittz',               'Nady T.N.',                            '374288268661088',              2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Carie',          'Humbatch',            'chumbatch10',             'Carie H.C.',                            '372301432743807',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Hillard',        'Meaton',              'hmeaton11',               'Hillard M.H.',                            '374622225060051',           2              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Cyrillus',       'Heindl',              'cheindl12',               'Cyrillus H.C.',                            '374622941238080',          2              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Danna',          'Joselevitch',         'djoselevitch13',          'Danna J.D.',                            '374288809085011',             2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Fee',            'Gouldsmith',          'fgouldsmith14',           'Fee G.F.',                            '372301953485580',               2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Jeanne',         'Wooldridge',          'jwooldridge15',           'Jeanne W.J.',                            '337941727071572',            2          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Niles',          'Cuttell',             'ncuttell16',              'Niles C.N.',                            '374622882455750',             3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Shepherd',       'Jiranek',             'sjiranek17',              'Shepherd J.S.',                            '337941246557119',          3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Mariette',       'Krinks',              'mkrinks18',               'Mariette K.M.',                            '374288535856461',          3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Alanson',        'Milne',               'amilne19',                'Alanson M.A.',                            '374288395023962',           3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Eugine',         'Govier',              'egovier1a',               'Eugine G.E.',                            '374288929989811',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Rudyard',        'Mehaffey',            'rmehaffey1b',             'Rudyard M.R.',                            '374288183180024',           3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Sascha',         'Ashtonhurst',         'sashtonhurst1c',          'Sascha A.S.',                            '345954964861886',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Bernie',         'Purple',              'bpurple1d',               'Bernie P.B.',                            '374283245989058',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Jacklyn',        'Chasle',              'jchasle1e',               'Jacklyn C.J.',                            '349540530977441',           3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Cati',           'Pash',                'cpash1f',                 'Cati P.C.',                            '375972384536279',              3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Alia',           'Yeowell',             'ayeowell1g',              'Alia Y.A.',                            '346707676795357',              3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Evangeline',     'Paine',               'epaine1h',                'Evangeline P.E.',                            '374283743418972',        3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Nevile',         'Waple',               'nwaple1i',                'Nevile W.N.',                            '337941615640819',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Tyson',          'Aikman',              'taikman1j',               'Tyson A.T.',                            '374622162990344',             3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Ichabod',        'Liven',               'iliven1k',                'Ichabod L.I.',                            '374288999988776',           3              );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Stacee',         'Fuster',              'sfuster1l',               'Stacee F.S.',                            '337941203416374',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Godfry',         'Lpiscopi',            'glepiscopi1m',            'Godfry L.G.',                            '337941304998684',            3          );
insert into students (name, second_name, third_name, initials, card_number, group_id) values ('Dominick',       'Hugk',                'dhugk1n',                 'Dominick H.D.',                            '337941180642539',          3              );



create table attendance
(
    student_id integer,
    data date,
    lecture_id integer,
    group_id integer,
    presence_value integer,

    foreign key(group_id) references group_id(id),
    foreign key(student_id) references students(id)
);


select *
from attendance
order by data;


INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '10-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '10-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '10-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '10-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '10-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '10-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '10-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '10-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '11-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '11-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '11-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '11-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '11-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '11-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '11-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '11-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '11-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '11-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '11-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '11-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '13-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '13-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '13-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '13-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '13-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '13-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '13-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '14-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '14-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '14-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '14-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '14-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '14-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '14-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '14-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '14-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '15-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '15-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '15-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '15-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '15-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '15-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '15-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '15-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '16-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '16-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '16-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '16-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '16-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '16-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '16-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '16-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '16-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '16-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '16-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '16-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '16-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '16-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '17-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '17-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '17-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '17-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '17-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '17-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '17-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '17-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '17-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '17-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '17-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '17-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '17-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '17-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '18-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '18-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '18-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '18-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '18-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '18-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '18-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '18-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '18-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '18-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '18-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '18-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '18-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '18-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '19-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '19-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '19-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '19-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '19-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '19-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '20-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '20-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '20-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '20-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '20-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '20-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '20-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '20-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '20-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '20-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '20-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '20-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '20-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '20-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '21-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '21-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '21-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '21-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '21-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '21-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '21-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '21-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '21-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '21-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '21-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '21-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '21-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '21-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '21-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '21-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '21-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '21-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '21-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '22-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '22-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '22-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '22-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '22-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '22-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '22-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '22-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '22-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '22-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '22-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '22-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '23-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '23-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '23-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '23-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '23-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '23-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '23-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '23-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '23-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '23-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '23-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '23-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '23-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '24-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '24-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '24-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '24-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '24-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '24-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '24-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '24-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '24-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '24-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '24-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '24-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '24-05-2024', 2, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '25-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '25-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '25-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '25-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '25-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '25-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '25-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '25-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '25-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '25-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '25-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '25-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '25-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '26-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '26-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '26-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '26-05-2024', 2, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '26-05-2024', 2, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '26-05-2024', 2, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '27-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '27-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '27-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '27-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '27-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '27-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '27-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '27-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '27-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '27-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '27-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '27-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '27-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (1, '29-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (2, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (3, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (4, '29-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (5, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (6, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (7, '29-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (8, '29-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (9, '29-05-2024', 1, 1, 3);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (10, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (11, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (12, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (13, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (14, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (15, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (16, '29-05-2024', 1, 1, 0);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (17, '29-05-2024', 1, 1, 2);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (18, '29-05-2024', 1, 1, 1);
INSERT INTO attendance (student_id, data, lecture_id, group_id, presence_value) VALUES (19, '29-05-2024', 1, 1, 1);

INSERT INTO exam (id, exam_name) VALUES 
(1, '10th Standard'),
(2, 'PUC'),
(3, 'CET'),
(4, 'JEE'),
(5, 'NEET'),
(6, 'VTU Sem 3'),
(7, 'VTU Sem 5');

INSERT INTO subject (subject_name, weightage, exam_id) VALUES
('Math', 5, 1),
('Science', 5, 1),
('English', 3, 1),

('Physics', 5, 2),
('Chemistry', 5, 2),
('Mathematics', 5, 2),
('Biology', 4, 2),

('Mathematics', 5, 3),
('Physics', 4, 3),
('Chemistry', 4, 3),

('Mathematics', 6, 4),
('Physics', 6, 4),
('Chemistry', 5, 4),

('Biology', 6, 5),
('Chemistry', 5, 5),
('Physics', 4, 5),

('Data Structures', 5, 6),
('Digital Electronics', 4, 6),
('OOP', 4, 6),
('Discrete Math', 3, 6),

('Computer Networks', 5, 7),
('Operating Systems', 5, 7),
('DBMS', 4, 7),
('Microprocessors', 4, 7);

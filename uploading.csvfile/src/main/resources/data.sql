INSERT INTO sensor (id, name, location, active, sensor) VALUES
('s001', 'Sensor Temp Norte', 'Estufa Norte', true, 'CLIMATE'),
('s002', 'Sensor pH Lote A', 'Lote A', true, 'PH'),
('s003', 'Sensor Nível Tanque 1', 'Tanque Principal', true, 'TANK_LEVEL'),
('s004', 'Sensor Solo Leste', 'Campo Leste', true, 'SOIL'),
('s005', 'Sensor Temp Sul', 'Estufa Sul', false, 'CLIMATE'),
('s006', 'Sensor pH Lote B', 'Lote B', true, 'PH'),
('s007', 'Sensor Nível Tanque 2', 'Tanque Secundário', true, 'TANK_LEVEL'),
('s008', 'Sensor Solo Oeste', 'Campo Oeste', true, 'SOIL'),
('s009', 'Sensor Temp Central', 'Galpão Central', true, 'CLIMATE'),
('s010', 'Sensor pH Irrigação', 'Sistema Irrigação', false, 'PH');

-- Localizações dos sensores
INSERT INTO location_sensor (id, sensor_id, location, start_date, end_date) VALUES
('loc01', 's001', 'Estufa Norte - Setor A', '2026-01-10 08:00:00', NULL),
('loc02', 's002', 'Lote A - Canteiro 3', '2026-02-15 09:30:00', NULL),
('loc03', 's003', 'Tanque Principal - Lado Leste', '2026-01-20 07:00:00', NULL),
('loc04', 's004', 'Campo Leste - Parcela 12', '2026-03-01 06:00:00', NULL),
('loc05', 's005', 'Estufa Sul - Setor B', '2025-11-05 10:00:00', '2026-04-01 10:00:00'),
('loc06', 's006', 'Lote B - Canteiro 7', '2026-04-10 08:00:00', NULL),
('loc07', 's007', 'Tanque Secundario - Centro', '2026-02-28 07:30:00', NULL),
('loc08', 's008', 'Campo Oeste - Parcela 5', '2026-05-01 06:00:00', NULL),
('loc09', 's009', 'Galpao Central - Corredor 2', '2026-03-15 09:00:00', NULL),
('loc10', 's010', 'Sistema Irrigacao - Bomba 1', '2025-12-01 08:00:00', '2026-03-20 08:00:00');

-- Leituras dos sensores
INSERT INTO readings (id, sensor_id, reading_value, reading_datetime, location_id) VALUES
('r001', 's001', 28.5, '2026-06-01 08:00:00', 'loc01'),
('r002', 's001', 30.2, '2026-06-01 12:00:00', 'loc01'),
('r003', 's002', 6.8, '2026-06-01 09:00:00', 'loc02'),
('r004', 's003', 75.0, '2026-06-01 07:30:00', 'loc03'),
('r005', 's004', 42.3, '2026-06-02 06:15:00', 'loc04'),
('r006', 's006', 7.1, '2026-06-02 08:45:00', 'loc06'),
('r007', 's007', 60.5, '2026-06-02 07:00:00', 'loc07'),
('r008', 's008', 38.9, '2026-06-03 06:30:00', 'loc08'),
('r009', 's009', 25.7, '2026-06-03 10:00:00', 'loc09'),
('r010', 's001', 29.1, '2026-06-04 08:00:00', 'loc01'),
('r011', 's003', 68.2, '2026-06-04 07:30:00', 'loc03'),
('r012', 's004', 44.0, '2026-06-05 06:00:00', 'loc04');

-- Usuarios (senhas com BCrypt: admin=admin123, user=user123)
INSERT INTO users (id, login, password, role) VALUES
('u001', 'admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN'),
('u002', 'joao', '$2a$10$DowJones2023hash000000000000000000000000000000000000', 'USER'),
('u003', 'maria', '$2a$10$MariaSilva2023hash00000000000000000000000000000000000', 'USER'),
('u004', 'carlos', '$2a$10$CarlosPereira23hash0000000000000000000000000000000000', 'ADMIN');
CREATE DATABASE IF NOT EXISTS meditrack;
USE meditrack;
CREATE TABLE IF NOT EXISTS medicines (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 category VARCHAR(60),
 quantity INT NOT NULL DEFAULT 0,
 reorder_level INT NOT NULL DEFAULT 10,
 expiry_date DATE NOT NULL
);
INSERT INTO medicines (name,category,quantity,reorder_level,expiry_date)
SELECT 'Paracetamol 500mg','Tablet',120,30,DATE_ADD(CURDATE(), INTERVAL 180 DAY)
WHERE NOT EXISTS (SELECT 1 FROM medicines WHERE name='Paracetamol 500mg');
INSERT INTO medicines (name,category,quantity,reorder_level,expiry_date)
SELECT 'Cetirizine 10mg','Tablet',8,20,DATE_ADD(CURDATE(), INTERVAL 240 DAY)
WHERE NOT EXISTS (SELECT 1 FROM medicines WHERE name='Cetirizine 10mg');
INSERT INTO medicines (name,category,quantity,reorder_level,expiry_date)
SELECT 'Vitamin C 500mg','Supplement',65,15,DATE_ADD(CURDATE(), INTERVAL 18 DAY)
WHERE NOT EXISTS (SELECT 1 FROM medicines WHERE name='Vitamin C 500mg');

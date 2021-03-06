﻿-- Script was generated by Devart dbForge Studio for MySQL, Version 6.1.166.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 15/10/2014 03:19:10 p.m.
-- Server version: 5.1.36-community-log
-- Client version: 4.1

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

-- 
-- Set default database
--
USE bd_codigobarras;

--
-- Definition for table tbljornadas
--
DROP TABLE IF EXISTS tbljornadas;
CREATE TABLE tbljornadas (
  idJornada INT(11) NOT NULL AUTO_INCREMENT,
  tiempo VARCHAR(255) DEFAULT NULL,
  horaInicio VARCHAR(255) DEFAULT NULL,
  horaSalida VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (idJornada)
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tblsalida
--
DROP TABLE IF EXISTS tblsalida;
CREATE TABLE tblsalida (
  codigoSalida VARCHAR(255) DEFAULT NULL
)
ENGINE = MYISAM
AVG_ROW_LENGTH = 20
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tbltipousuario
--
DROP TABLE IF EXISTS tbltipousuario;
CREATE TABLE tbltipousuario (
  idTipoUsuario VARCHAR(255) NOT NULL DEFAULT '',
  Tipo VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (idTipoUsuario)
)
ENGINE = INNODB
AVG_ROW_LENGTH = 8192
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tblusuarios
--
DROP TABLE IF EXISTS tblusuarios;
CREATE TABLE tblusuarios (
  idUsuario INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) DEFAULT NULL,
  usuario VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  idTipoUsuario VARCHAR(255) DEFAULT NULL,
  email VARCHAR(50) DEFAULT NULL,
  telefono VARCHAR(255) DEFAULT NULL,
  apellidos VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (idUsuario),
  CONSTRAINT FK_tblusuarios_tbltipousuario_idTipoUsuario FOREIGN KEY (idTipoUsuario)
    REFERENCES tbltipousuario(idTipoUsuario) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 503990077
AVG_ROW_LENGTH = 3276
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tblcontrol
--
DROP TABLE IF EXISTS tblcontrol;
CREATE TABLE tblcontrol (
  idControl INT(11) NOT NULL AUTO_INCREMENT,
  idUsuario INT(11) DEFAULT NULL,
  hora VARCHAR(255) DEFAULT NULL,
  horafin VARCHAR(255) DEFAULT NULL,
  horastrab VARCHAR(255) DEFAULT NULL,
  fecha VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (idControl),
  CONSTRAINT FK_tblcontrol_tblusuarios_idUsuario FOREIGN KEY (idUsuario)
    REFERENCES tblusuarios(idUsuario) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 28
AVG_ROW_LENGTH = 3276
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tblhorarios
--
DROP TABLE IF EXISTS tblhorarios;
CREATE TABLE tblhorarios (
  idHorario INT(11) NOT NULL AUTO_INCREMENT,
  idUsuario INT(11) DEFAULT NULL,
  idJornada INT(11) DEFAULT NULL,
  fechaInicio DATE DEFAULT NULL,
  fechaFinal DATE DEFAULT NULL,
  PRIMARY KEY (idHorario),
  CONSTRAINT FK_tblhorarios_tbljornadas_idJornada FOREIGN KEY (idJornada)
    REFERENCES tbljornadas(idJornada) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_tblhorarios_tblusuarios_idUsuario FOREIGN KEY (idUsuario)
    REFERENCES tblusuarios(idUsuario) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 17
AVG_ROW_LENGTH = 2730
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

DELIMITER $$

--
-- Definition for procedure agregarUsuario
--
DROP PROCEDURE IF EXISTS agregarUsuario$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE agregarUsuario(IN p_idUsuario varchar(255), IN p_nombre varchar(255), IN p_usuario varchar(255), IN p_password varchar(255), IN p_idTipoUsuario varchar(255), IN p_email varchar(50), IN p_telefono varchar(255), IN p_apellidos varchar(255))
BEGIN
INSERT INTO `tblusuarios`(`idUsuario`, `nombre`, `usuario`, `password`, 
`idTipoUsuario`, `email`, `telefono`, `apellidos`) 
VALUES (p_idUsuario, p_nombre, p_usuario, p_password, 
p_idTipoUsuario, p_email, p_telefono, p_apellidos);
END
$$

--
-- Definition for procedure buscadato
--
DROP PROCEDURE IF EXISTS buscadato$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE buscadato(IN $idUsuario INT)
BEGIN
select * FROM tblusuarios where idUsuario= $idUsuario;

END
$$

--
-- Definition for procedure Buscarhorarios
--
DROP PROCEDURE IF EXISTS Buscarhorarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE Buscarhorarios(
IN p_idHorario int(11))
BEGIN
SELECT `idHorario`, `idUsuario`, `idJornada`, `fecha`
FROM `tblhorarios`
WHERE `idHorario` = p_idHorario;
END
$$

--
-- Definition for procedure buscarJornada
--
DROP PROCEDURE IF EXISTS buscarJornada$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE buscarJornada(
IN p_idJornada int(11))
BEGIN
SELECT `idJornada`, `tiempo`, `horaInicio`, `horaSalida`
FROM `tbljornadas`
WHERE `idJornada` = p_idJornada;
END
$$

--
-- Definition for procedure buscarJornadaTodo
--
DROP PROCEDURE IF EXISTS buscarJornadaTodo$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE buscarJornadaTodo()
BEGIN
SELECT  `idJornada` as ITEM,`tiempo` as TURNO, `horaInicio` as INICIO, `horaSalida` as SALIDA
FROM `tbljornadas`;
END
$$

--
-- Definition for procedure cambiarClave
--
DROP PROCEDURE IF EXISTS cambiarClave$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE cambiarClave(
  IN CLAVE varchar(255))
BEGIN
UPDATE `tblsalida` 
SET `codigosalida` = CLAVE;
END
$$

--
-- Definition for procedure cargarClave
--
DROP PROCEDURE IF EXISTS cargarClave$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE cargarClave()
BEGIN
select * from tblsalida;
END
$$

--
-- Definition for procedure Cargarhorarios
--
DROP PROCEDURE IF EXISTS Cargarhorarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE Cargarhorarios()
BEGIN
select h.idhorario as ITEM,u.idusuario as Cedula,concat(u.nombre,' ',u.apellidos) as Empleado,j.tiempo as Turno,j.horainicio as Entrada,j.horasalida as Salida,
DATE_FORMAT(h.fechaInicio,'%d/%m/%Y') AS Inicio,DATE_FORMAT(h.fechaFinal,'%d/%m/%Y') AS Fin from tblhorarios h inner join tblusuarios u on h.idUsuario = u.idUsuario
  inner join tbljornadas j on h.idJornada = j.idJornada;
END
$$

--
-- Definition for procedure Editarhorarios
--
DROP PROCEDURE IF EXISTS Editarhorarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE Editarhorarios(
IN p_idHorario int(11), 
IN p_idUsuario int(11), 
IN p_idJornada int(11), 
IN p_fecha date
)
BEGIN
UPDATE `tblhorarios` 
SET `idUsuario` = p_idUsuario, `idJornada` = p_idJornada, `fecha` = p_fecha
WHERE `idHorario` = p_idHorario;
END
$$

--
-- Definition for procedure editarJornada
--
DROP PROCEDURE IF EXISTS editarJornada$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE editarJornada(
IN p_idJornada int(11), 
IN p_tiempo varchar(255), 
IN p_horaInicio varchar(255), 
IN p_horaSalida varchar(255)
)
BEGIN
UPDATE `tbljornadas` 
SET `tiempo` = p_tiempo, `horaInicio` = p_horaInicio, `horaSalida` = p_horaSalida
WHERE `idJornada` = p_idJornada;
END
$$

--
-- Definition for procedure editarUsuario
--
DROP PROCEDURE IF EXISTS editarUsuario$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE editarUsuario(
IN p_idUsuario varchar(255), 
IN p_nombre varchar(255), 
IN p_usuario varchar(255), 
IN p_password varchar(255), 
IN p_idTipoUsuario varchar(255), 
IN p_email varchar(50), 
IN p_telefono varchar(255), 
IN p_apellidos varchar(255)
)
BEGIN
UPDATE `tblusuarios` 
SET `nombre` = p_nombre, `usuario` = p_usuario, `password` = p_password, `idTipoUsuario` = p_idTipoUsuario, 
`email` = p_email, `telefono` = p_telefono, `apellidos` = p_apellidos
WHERE `idUsuario` = p_idUsuario;
END
$$

--
-- Definition for procedure Eliminarhorarios
--
DROP PROCEDURE IF EXISTS Eliminarhorarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE Eliminarhorarios(
IN p_idHorario int(11))
BEGIN
DELETE FROM `tblhorarios`
WHERE `idHorario` = p_idHorario;
END
$$

--
-- Definition for procedure eliminarJornada
--
DROP PROCEDURE IF EXISTS eliminarJornada$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE eliminarJornada(
IN p_idJornada int(11))
BEGIN
DELETE FROM `tbljornadas`
WHERE `idJornada` = p_idJornada;
END
$$

--
-- Definition for procedure eliminarUsuarios
--
DROP PROCEDURE IF EXISTS eliminarUsuarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE eliminarUsuarios(
IN p_idUsuario int(11))
BEGIN
DELETE FROM `tblusuarios`
WHERE `idUsuario` = p_idUsuario;
END
$$

--
-- Definition for procedure guardardato
--
DROP PROCEDURE IF EXISTS guardardato$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE guardardato(IN $idUsuarios INT, IN $horas VARCHAR(255), IN $fechas VARCHAR(255), IN $tipos VARCHAR(255))
BEGIN
insert INTO tblcontrol VALUES(NULL,$idUsuarios,concat($fechas,' ',$horas),$fechas,$tipos); 
END
$$

--
-- Definition for procedure guardarJornada
--
DROP PROCEDURE IF EXISTS guardarJornada$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE guardarJornada(IN p_tiempo varchar(255), IN p_horaInicio varchar(255), IN p_horaSalida varchar(255))
BEGIN
INSERT INTO `tbljornadas`( `tiempo`, `horaInicio`, `horaSalida`) 
VALUES ( p_tiempo, p_horaInicio, p_horaSalida);
END
$$

--
-- Definition for procedure INSERTEMP2
--
DROP PROCEDURE IF EXISTS INSERTEMP2$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE INSERTEMP2(OUT V_SUMA VARCHAR(255))
BEGIN
  SELECT TIMEDIFF(horafin,hora) into V_SUMA from tblcontrol where idusuario = 2;
    UPDATE tblcontrol SET horastrab = (V_SUMA);
END
$$

--
-- Definition for procedure INSERT_HORA
--
DROP PROCEDURE IF EXISTS INSERT_HORA$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE INSERT_HORA(IN V_HORA VARCHAR(255), IN V_IDUSUA INT, OUT V_MAXID INT, OUT V_MAX INT,OUT V_SUMA VARCHAR(255))
BEGIN
  SELECT MAX(IDCONTROL)+1 INTO V_MAXID FROM tblcontrol;
  SELECT MAX(IDCONTROL)  INTO V_MAX FROM tblcontrol where idUsuario = V_IDUSUA;
  SELECT TIMEDIFF(V_HORA,hora) INTO V_SUMA from tblcontrol WHERE idControl = (V_MAX);
  IF (SELECT MAX(HORA) FROM tblcontrol WHERE HORAFIN IS NULL AND idUsuario = V_IDUSUA) THEN 
  UPDATE tblcontrol SET horafin = (V_HORA) where idControl = V_MAX; 
  UPDATE tblcontrol SET horastrab = (V_SUMA) where IDCONTROL = V_MAX; 
  ELSE 
  INSERT INTO tblcontrol (idControl,idUsuario,hora,horafin,horastrab,fecha) VALUES(V_MAXID,V_IDUSUA,V_HORA,NULL,NULL,current_date);
  END IF;
END
$$

--
-- Definition for procedure Registrarhorarios
--
DROP PROCEDURE IF EXISTS Registrarhorarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE Registrarhorarios(IN p_idUsuario int(11), IN p_idJornada int(11), IN p_fecha date, IN p_fechas date)
  DETERMINISTIC
BEGIN
INSERT INTO `tblhorarios`(`idUsuario`, `idJornada`, `fechaInicio`, `fechaFinal`) 
VALUES ( p_idUsuario, p_idJornada, p_fecha, p_fechas);
END
$$

--
-- Definition for procedure TodosUsuarios
--
DROP PROCEDURE IF EXISTS TodosUsuarios$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE TodosUsuarios()
BEGIN

SELECT u.idUsuario as Cedula,concat (u.nombre,' ',u.apellidos) as Nombre, u.usuario as Usuario, u.password as Contraseña, 
t.tipo as TipoUsuario, u.email as Correo, telefono as Telefono
FROM tblusuarios u inner join tbltipousuario t
  on u.idtipousuario = t.idtipousuario;
END
$$

--
-- Definition for procedure validacionEntrada
--
DROP PROCEDURE IF EXISTS validacionEntrada$$
CREATE DEFINER = 'root'@'127.0.0.1'
PROCEDURE validacionEntrada(IN $idUsuario INT)
BEGIN

SELECT MAX(HORA) FROM tblcontrol WHERE HORAFIN IS NULL AND idUsuario = $idUsuario;
END
$$

DELIMITER ;

-- 
-- Dumping data for table tbljornadas
--
INSERT INTO tbljornadas VALUES
(1, 'Madrugada', '12:00 am', '08:00 am'),
(2, 'Mañana', '08:00 am', '04:00 pm'),
(3, 'Tarde noche', '04:00 pm', '12:00 am');

-- 
-- Dumping data for table tblsalida
--
INSERT INTO tblsalida VALUES
('salas1010');

-- 
-- Dumping data for table tbltipousuario
--
INSERT INTO tbltipousuario VALUES
('1', 'Administrador'),
('2', 'Empleado');

-- 
-- Dumping data for table tblusuarios
--
INSERT INTO tblusuarios VALUES
(2, 'Pandolfo', 'pando', '1234', '2', 'pando@gmail.com', '34568798', 'Agripino'),
(115570610, 'Luis Antonio', 'L.Vega', '0000', '2', 'luis.vega@invenio.org', '88583489', 'Vega Vega'),
(115710810, 'Luis', 'pirris', '1234', '1', 'pirrisSalas_10@hotmail.com', '8876598', 'Salas'),
(503350689, 'Ronald David', 'R.Vargas', '1234', '2', 'ronald.vargas@invenio.org', '2345-5678', 'Vargas Garcia'),
(503990076, 'Jafeth', 'jaf', '1234', '2', 'jaf@gmail.com', '56789054', 'Briceño');

-- 
-- Dumping data for table tblcontrol
--
INSERT INTO tblcontrol VALUES
(22, 2, '2014-09-16 04:19:47', '2014-09-16 04:19:52', '24:45:05', '2014-09-16'),
(23, 2, '2014-09-16 04:35:59', '2014-09-16 04:38:21', '04:17:22', '2014-10-16'),
(24, 2, '2014-11-20 10:00:00', '2014-11-20 15:00:00', '26:28:00', '2014-09-16'),
(25, 115570610, '2014-11-20 10:00:00', '2014-11-20 19:00:00', '09:00:00', '2014-09-16'),
(26, 503990076, '2014-09-16 11:33:20', '2014-09-16 11:33:57', '00:00:37', '2014-09-16');

-- 
-- Dumping data for table tblhorarios
--
INSERT INTO tblhorarios VALUES
(9, 115570610, 1, '2014-08-18', '2014-08-23'),
(11, 115570610, 3, '2014-08-25', '2014-08-31'),
(12, 2, 3, '2014-08-11', '2014-08-17'),
(14, 115570610, 1, '2014-09-08', '2014-08-18'),
(15, 503990076, 3, '2014-08-18', '2014-08-25'),
(16, 503350689, 2, '2014-10-13', '2014-10-17');

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
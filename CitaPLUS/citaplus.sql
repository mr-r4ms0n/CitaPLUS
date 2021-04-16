-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.23 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla citaplus.citas
CREATE TABLE IF NOT EXISTS `citas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pacienteId` int NOT NULL,
  `nombrePaciente` varchar(80)  NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `estatusCitasId` int NOT NULL DEFAULT '1',
  `usuarioId` int DEFAULT NULL,
  `servicioId` int DEFAULT NULL,
  `fechaRegistro` date NOT NULL,
  `fechaCancelo` date DEFAULT NULL,
  `usuarioEdito` date DEFAULT NULL,
  `descripcionCancelo` varchar(150)  DEFAULT NULL,
  `fechaEdito` date DEFAULT NULL,
  `usuarioAtiende` int DEFAULT NULL,
  `fechaAtendida` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `citas_pacienteId` (`pacienteId`),
  KEY `citas_estatusCitasId` (`estatusCitasId`),
  KEY `citas_usuarioId` (`usuarioId`),
  KEY `citas_nombrePaciente` (`nombrePaciente`),
  CONSTRAINT `citas_estatusCitasId` FOREIGN KEY (`estatusCitasId`) REFERENCES `estatuscitas` (`id`),
  CONSTRAINT `citas_nombrePaciente` FOREIGN KEY (`nombrePaciente`) REFERENCES `pacientes` (`nombre`),
  CONSTRAINT `citas_pacienteId` FOREIGN KEY (`pacienteId`) REFERENCES `pacientes` (`id`),
  CONSTRAINT `citas_usuarioId` FOREIGN KEY (`usuarioId`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- Volcando datos para la tabla citaplus.citas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;

-- Volcando estructura para tabla citaplus.estatuscitas
CREATE TABLE IF NOT EXISTS `estatuscitas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(80)  NOT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `estatuscitas_descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ;

-- Volcando datos para la tabla citaplus.estatuscitas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estatuscitas` DISABLE KEYS */;
INSERT INTO `estatuscitas` (`id`, `descripcion`, `estatus`) VALUES
	(1, 'proxima', 1),
	(2, 'atendida', 2),
	(3, 'cancelada', 3);
/*!40000 ALTER TABLE `estatuscitas` ENABLE KEYS */;

-- Volcando estructura para tabla citaplus.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `foto` varchar(80)  NOT NULL,
  `nombre` varchar(80) CHARACTER SET utf8  NOT NULL,
  `apellidoPaterno` varchar(80)  NOT NULL,
  `apellidoMaterno` varchar(80)  NOT NULL,
  `sexo` enum('Hombre','Mujer')  NOT NULL DEFAULT 'Hombre',
  `telefono` bigint DEFAULT NULL,
  `correo` varchar(80)  DEFAULT NULL,
  `estatus` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pacientes_nombre` (`nombre`),
  UNIQUE KEY `pacientes_telefono` (`telefono`),
  UNIQUE KEY `pacientes_correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- Volcando datos para la tabla citaplus.pacientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;

-- Volcando estructura para tabla citaplus.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) CHARACTER SET utf8mb4  NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidoPaterno` varchar(50) DEFAULT NULL,
  `apellidoMaterno` varchar(50) DEFAULT NULL,
  `contraseña` varchar(128) CHARACTER SET utf8mb4  NOT NULL,
  `estatus` tinyint(1) DEFAULT '1',
  `sexo` enum('Hombre','Mujer') CHARACTER SET utf8mb4  NOT NULL,
  `foto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuarios_usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla citaplus.usuarios: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `usuario`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `contraseña`, `estatus`, `sexo`, `foto`) VALUES
	(1, 'r4ms0n', 'Kevin', 'Benitez', 'Valentin', 'Z5Pkgize6+4=', 1, 'Hombre', 'Hombre.png'),
	(2, 'decks', 'David', 'Vergara', 'Gomez', 'sA3lwdxRByI=', 1, 'Hombre', 'Mujer.png');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

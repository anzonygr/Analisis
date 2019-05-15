-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-05-2019 a las 06:56:49
-- Versión del servidor: 10.1.39-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `COD_ACTIVIDAD` int(11) NOT NULL,
  `COD_ASIGNACION` int(11) NOT NULL,
  `COD_GRADO` int(11) NOT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `COD_SECCION` int(11) NOT NULL,
  `COD_CATEDRATICO` int(11) NOT NULL,
  `TITULO` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOTA` int(11) DEFAULT NULL,
  `FECHA_ENTREGA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

CREATE TABLE `asignacion` (
  `COD_ASIGNACION` int(11) NOT NULL,
  `COD_GRADO` int(11) NOT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `COD_SECCION` int(11) NOT NULL,
  `COD_CATEDRATICO` int(11) NOT NULL,
  `COD_ESTUDIANTE` int(11) DEFAULT NULL,
  `HORARIO` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ZONA` int(11) DEFAULT NULL,
  `PARCIAL_1` int(11) DEFAULT NULL,
  `PARCIAL_2` int(11) DEFAULT NULL,
  `EXAMEN_FINAL` int(11) DEFAULT NULL,
  `ESTADO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asignacion`
--

INSERT INTO `asignacion` (`COD_ASIGNACION`, `COD_GRADO`, `COD_CURSO`, `COD_SECCION`, `COD_CATEDRATICO`, `COD_ESTUDIANTE`, `HORARIO`, `ZONA`, `PARCIAL_1`, `PARCIAL_2`, `EXAMEN_FINAL`, `ESTADO`) VALUES
(1, 4, 1, 1, 1, 1, '15:30', 20, 7, 15, 40, 'asignado'),
(2, 4, 2, 1, 1, 1, '15:30', 20, 7, 15, 40, 'asignado'),
(3, 4, 3, 1, 1, 1, '15:30', 20, 7, 15, 40, 'asignado'),
(4, 4, 4, 1, 1, 1, '15:30', 20, 7, 15, 40, 'asignado'),
(5, 4, 1, 2, 1, 2, '15:30', 20, 7, 15, 40, 'asignado'),
(6, 4, 2, 2, 1, 2, '15:30', 20, 7, 15, 40, 'asignado'),
(7, 4, 3, 2, 1, 2, '15:30', 20, 7, 15, 40, 'asignado'),
(8, 4, 4, 2, 1, 2, '15:30', 20, 7, 15, 40, 'asignado'),
(9, 4, 1, 1, 1, 1, '15:30', 0, 0, 0, 0, 'asignado'),
(10, 4, 1, 1, 1, 1, '15:30', 0, 0, 0, 0, 'asignado'),
(11, 4, 1, 2, 1, 1, '15:30', 0, 0, 0, 0, 'asignado'),
(12, 4, 3, 2, 1, 1, '15:30', 0, 0, 0, 0, 'asignado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catedratico`
--

CREATE TABLE `catedratico` (
  `COD_CATEDRATICO` int(11) NOT NULL,
  `COD_ROL` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO_1` int(8) DEFAULT NULL,
  `TELEFONO_2` int(11) DEFAULT NULL,
  `CORREO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DPI` varchar(13) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SEXO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_NACIMIENTO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TITULO` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `catedratico`
--

INSERT INTO `catedratico` (`COD_CATEDRATICO`, `COD_ROL`, `NOMBRE`, `APELLIDO`, `TELEFONO_1`, `TELEFONO_2`, `CORREO`, `DIRECCION`, `DPI`, `SEXO`, `FECHA_NACIMIENTO`, `TITULO`) VALUES
(1, 2, 'CARLOS', 'RUIZ', 12345678, 87654321, 'cruiz@gmail.com', '16-45', '1234152630101', 'MASCULINO', '02/03/1978', 'PERITO CONTADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `COD_GRADO` int(11) DEFAULT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `DESCRIPCION` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`COD_GRADO`, `COD_CURSO`, `DESCRIPCION`) VALUES
(4, 1, 'MATEMATICA'),
(4, 2, 'COMUNICACION Y LENGU'),
(4, 3, 'CIENCIAS NATURALES'),
(4, 4, 'CIENCIAS SOCIALES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encargado`
--

CREATE TABLE `encargado` (
  `COD_ENCARGADO` int(11) NOT NULL,
  `COD_ROL` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO_1` int(8) DEFAULT NULL,
  `TELEFONO_2` int(11) DEFAULT NULL,
  `CORREO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PARENTESCO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DPI` varchar(13) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `encargado`
--

INSERT INTO `encargado` (`COD_ENCARGADO`, `COD_ROL`, `NOMBRE`, `APELLIDO`, `TELEFONO_1`, `TELEFONO_2`, `CORREO`, `PARENTESCO`, `DIRECCION`, `DPI`) VALUES
(1, 4, 'RAFAEL', 'GONZALEZ', 12345678, 87456123, 'rgonzalez@gmail.com', 'PADRE', '16-48', '1234152614501');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega_actividad`
--

CREATE TABLE `entrega_actividad` (
  `COD_ENTREGA_ACTIVIDAD` int(11) NOT NULL,
  `COD_ACTIVIDAD` int(11) NOT NULL,
  `COD_ASIGNACION` int(11) NOT NULL,
  `COD_GRADO` int(11) NOT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `COD_SECCION` int(11) NOT NULL,
  `COD_CATEDRATICO` int(11) NOT NULL,
  `COD_ESTUDIANTE` int(11) DEFAULT NULL,
  `DESCRIPCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOTA` int(11) DEFAULT NULL,
  `ESTADO` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `COD_ESTUDIANTE` int(11) NOT NULL,
  `COD_ROL` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO_1` int(8) DEFAULT NULL,
  `TELEFONO_2` int(11) DEFAULT NULL,
  `SEXO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUI` varchar(13) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_NACIMIENTO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `COD_GRADO` int(11) DEFAULT NULL,
  `COD_ENCARGADO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`COD_ESTUDIANTE`, `COD_ROL`, `NOMBRE`, `APELLIDO`, `TELEFONO_1`, `TELEFONO_2`, `SEXO`, `DIRECCION`, `CUI`, `FECHA_NACIMIENTO`, `COD_GRADO`, `COD_ENCARGADO`) VALUES
(1, 3, 'ANZONY', 'GONZALEZ', 12345678, 12345678, 'MASCULINO', '16-78 2 av.', '6125126350101', '06/04/1988', 4, 1),
(2, 3, 'ABIGAIL', 'GONZALEZ', 12345678, 12345678, 'FEMENINO', '16-96 4ta. calle', '6125126350101', '02/06/1978', 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `COD_GRADO` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`COD_GRADO`, `DESCRIPCION`) VALUES
(1, 'PREKINDER'),
(2, 'KINDER'),
(3, 'PREPIMARIA'),
(4, '1RO. PRIMARIA'),
(5, '2DO. PRIMARIA'),
(6, '3RO. PRIMARIA'),
(7, '4TO. PRIMARIA'),
(8, '5TO. PRIMARIA'),
(9, '6TO. PRIMARIA'),
(10, '7MO. BASICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `COD_ROL` int(11) NOT NULL,
  `COD_LOGIN` int(11) NOT NULL,
  `USUARIO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PASSWORD` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`COD_ROL`, `COD_LOGIN`, `USUARIO`, `PASSWORD`) VALUES
(1, 1, 'anzonyg@live.com', '1234'),
(3, 2, 'anzonyg@gmail.com', '123456'),
(3, 4, 'abygonzalez@gmail.com', '123456'),
(4, 1, 'rgonzalez@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `COD_ROL` int(11) NOT NULL,
  `DESCRIPCION` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`COD_ROL`, `DESCRIPCION`) VALUES
(1, 'ADMINISTRA'),
(2, 'CATEDRATIC'),
(3, 'ESTUDIANTE'),
(4, 'ENCARGADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `COD_GRADO` int(11) DEFAULT NULL,
  `COD_SECCION` int(11) NOT NULL,
  `DESCRIPCION` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`COD_GRADO`, `COD_SECCION`, `DESCRIPCION`) VALUES
(4, 1, 'A'),
(4, 2, 'B');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`),
  ADD KEY `COD_ASIGNACION` (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`);

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`),
  ADD KEY `COD_GRADO` (`COD_GRADO`),
  ADD KEY `COD_CURSO` (`COD_CURSO`),
  ADD KEY `COD_SECCION` (`COD_SECCION`),
  ADD KEY `COD_CATEDRATICO` (`COD_CATEDRATICO`),
  ADD KEY `COD_ESTUDIANTE` (`COD_ESTUDIANTE`);

--
-- Indices de la tabla `catedratico`
--
ALTER TABLE `catedratico`
  ADD PRIMARY KEY (`COD_CATEDRATICO`),
  ADD KEY `COD_ROL` (`COD_ROL`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`COD_CURSO`),
  ADD KEY `COD_GRADO` (`COD_GRADO`);

--
-- Indices de la tabla `encargado`
--
ALTER TABLE `encargado`
  ADD PRIMARY KEY (`COD_ENCARGADO`),
  ADD KEY `COD_ROL` (`COD_ROL`);

--
-- Indices de la tabla `entrega_actividad`
--
ALTER TABLE `entrega_actividad`
  ADD PRIMARY KEY (`COD_ENTREGA_ACTIVIDAD`,`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`),
  ADD KEY `COD_ACTIVIDAD` (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`COD_ESTUDIANTE`),
  ADD KEY `COD_ROL` (`COD_ROL`),
  ADD KEY `COD_ENCARGADO` (`COD_ENCARGADO`),
  ADD KEY `estudiante_ibfk_2` (`COD_GRADO`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`COD_GRADO`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`COD_ROL`,`COD_LOGIN`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`COD_ROL`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`COD_SECCION`),
  ADD KEY `COD_GRADO` (`COD_GRADO`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`) REFERENCES `asignacion` (`COD_ASIGNACION`, `COD_GRADO`, `COD_CURSO`, `COD_SECCION`, `COD_CATEDRATICO`);

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `asignacion_ibfk_1` FOREIGN KEY (`COD_GRADO`) REFERENCES `grado` (`COD_GRADO`),
  ADD CONSTRAINT `asignacion_ibfk_2` FOREIGN KEY (`COD_CURSO`) REFERENCES `curso` (`COD_CURSO`),
  ADD CONSTRAINT `asignacion_ibfk_3` FOREIGN KEY (`COD_SECCION`) REFERENCES `seccion` (`COD_SECCION`),
  ADD CONSTRAINT `asignacion_ibfk_4` FOREIGN KEY (`COD_CATEDRATICO`) REFERENCES `catedratico` (`COD_CATEDRATICO`),
  ADD CONSTRAINT `asignacion_ibfk_5` FOREIGN KEY (`COD_ESTUDIANTE`) REFERENCES `estudiante` (`COD_ESTUDIANTE`);

--
-- Filtros para la tabla `catedratico`
--
ALTER TABLE `catedratico`
  ADD CONSTRAINT `catedratico_ibfk_1` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`COD_GRADO`) REFERENCES `grado` (`COD_GRADO`);

--
-- Filtros para la tabla `encargado`
--
ALTER TABLE `encargado`
  ADD CONSTRAINT `encargado_ibfk_1` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`);

--
-- Filtros para la tabla `entrega_actividad`
--
ALTER TABLE `entrega_actividad`
  ADD CONSTRAINT `entrega_actividad_ibfk_1` FOREIGN KEY (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_CATEDRATICO`) REFERENCES `actividad` (`COD_ACTIVIDAD`, `COD_ASIGNACION`, `COD_GRADO`, `COD_CURSO`, `COD_SECCION`, `COD_CATEDRATICO`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`),
  ADD CONSTRAINT `estudiante_ibfk_2` FOREIGN KEY (`COD_GRADO`) REFERENCES `grado` (`COD_GRADO`),
  ADD CONSTRAINT `estudiante_ibfk_3` FOREIGN KEY (`COD_ENCARGADO`) REFERENCES `encargado` (`COD_ENCARGADO`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`);

--
-- Filtros para la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD CONSTRAINT `seccion_ibfk_1` FOREIGN KEY (`COD_GRADO`) REFERENCES `grado` (`COD_GRADO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

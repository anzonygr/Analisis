-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2019 a las 06:25:17
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

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
  `COD_PERSONA` int(11) NOT NULL,
  `TITULO` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOTA` int(11) DEFAULT NULL,
  `ESTADO` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
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
  `COD_PERSONA` int(11) NOT NULL,
  `HORARIO` time DEFAULT NULL,
  `ZONA` int(11) DEFAULT NULL,
  `PARCIAL_1` int(11) DEFAULT NULL,
  `PARCIAL_2` int(11) DEFAULT NULL,
  `EXAMEN_FINAL` int(11) DEFAULT NULL,
  `TOTAL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `COD_GRADO` int(11) NOT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HORARIO` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `COD_PERSONA` int(11) NOT NULL,
  `DESCRIPCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOTA` int(11) DEFAULT NULL,
  `ESTADO` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `COD_GRADO` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `COD_PERSONA` int(11) NOT NULL,
  `COD_ROL` int(11) DEFAULT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TELEFONO` int(8) DEFAULT NULL,
  `CORREO` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NIT` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUENTA` int(11) DEFAULT NULL,
  `COD_PADRE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `COD_ROL` int(11) NOT NULL,
  `DESCRIPCION` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `COD_GRADO` int(11) NOT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `COD_SECCION` int(11) NOT NULL,
  `DESCRIPCION` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`),
  ADD KEY `FK_ACTIVIDAD_ASIGNACION` (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`);

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`),
  ADD KEY `FK_SECC_ASIGNACION` (`COD_GRADO`,`COD_CURSO`,`COD_SECCION`),
  ADD KEY `FK_PERSONA_ASIGNACION` (`COD_PERSONA`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`COD_GRADO`,`COD_CURSO`);

--
-- Indices de la tabla `entrega_actividad`
--
ALTER TABLE `entrega_actividad`
  ADD PRIMARY KEY (`COD_ENTREGA_ACTIVIDAD`,`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`),
  ADD KEY `COD_ACTIVIDAD` (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`);

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
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`COD_PERSONA`),
  ADD KEY `FK_ROL_PERSONA` (`COD_ROL`),
  ADD KEY `FK_PERSONA_PERSONA` (`COD_PADRE`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`COD_ROL`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`COD_GRADO`,`COD_CURSO`,`COD_SECCION`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD CONSTRAINT `FK_ACTIVIDAD_ASIGNACION` FOREIGN KEY (`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`) REFERENCES `asignacion` (`COD_ASIGNACION`, `COD_GRADO`, `COD_CURSO`, `COD_SECCION`, `COD_PERSONA`) ON DELETE CASCADE;

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `FK_PERSONA_ASIGNACION` FOREIGN KEY (`COD_PERSONA`) REFERENCES `persona` (`COD_PERSONA`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_SECC_ASIGNACION` FOREIGN KEY (`COD_GRADO`,`COD_CURSO`,`COD_SECCION`) REFERENCES `seccion` (`COD_GRADO`, `COD_CURSO`, `COD_SECCION`) ON DELETE CASCADE;

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `FK_GRADO_CURSO` FOREIGN KEY (`COD_GRADO`) REFERENCES `grado` (`COD_GRADO`) ON DELETE CASCADE;

--
-- Filtros para la tabla `entrega_actividad`
--
ALTER TABLE `entrega_actividad`
  ADD CONSTRAINT `entrega_actividad_ibfk_1` FOREIGN KEY (`COD_ACTIVIDAD`,`COD_ASIGNACION`,`COD_GRADO`,`COD_CURSO`,`COD_SECCION`,`COD_PERSONA`) REFERENCES `actividad` (`COD_ACTIVIDAD`, `COD_ASIGNACION`, `COD_GRADO`, `COD_CURSO`, `COD_SECCION`, `COD_PERSONA`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `FK_ROL_LOGIN` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`) ON DELETE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `FK_PERSONA_PERSONA` FOREIGN KEY (`COD_PADRE`) REFERENCES `persona` (`COD_PERSONA`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_ROL_PERSONA` FOREIGN KEY (`COD_ROL`) REFERENCES `rol` (`COD_ROL`) ON DELETE CASCADE;

--
-- Filtros para la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD CONSTRAINT `FK_CURSO_SECCION` FOREIGN KEY (`COD_GRADO`,`COD_CURSO`) REFERENCES `curso` (`COD_GRADO`, `COD_CURSO`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2019 a las 22:17:09
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
  `HORARIO` time DEFAULT NULL,
  `ZONA` int(11) DEFAULT NULL,
  `PARCIAL_1` int(11) DEFAULT NULL,
  `PARCIAL_2` int(11) DEFAULT NULL,
  `EXAMEN_FINAL` int(11) DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `TITULO` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `COD_GRADO` int(11) DEFAULT NULL,
  `COD_CURSO` int(11) NOT NULL,
  `DESCRIPCION` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `HORARIO` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `COD_ENCARGADO` int(11) DEFAULT NULL
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
  `COD_GRADO` int(11) DEFAULT NULL,
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
  ADD KEY `COD_ENCARGADO` (`COD_ENCARGADO`);

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
  ADD CONSTRAINT `estudiante_ibfk_2` FOREIGN KEY (`COD_ENCARGADO`) REFERENCES `encargado` (`COD_ENCARGADO`);

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

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2022 a las 22:05:42
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `funator`
--
CREATE DATABASE IF NOT EXISTS `funator` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `funator`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `alumno_id` bigint(20) UNSIGNED NOT NULL,
  `carrera_id` bigint(20) NOT NULL,
  `nombre_alumno` text NOT NULL,
  `promedio` decimal(5,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`alumno_id`, `carrera_id`, `nombre_alumno`, `promedio`) VALUES
(4, 0, 'Rodrigo Maliachi', '79.40'),
(5, 1, 'Rafa Chavez', '32.00'),
(6, 1, 'Rafa Chavez Gomez', '90.00'),
(7, 1, 'Aridai Carvajal', '100.00'),
(8, 0, 'David Maria Colmena', '89.50'),
(9, 2, 'Alejandra Mejia', '94.00'),
(10, 2, 'Miranda Herrera', '88.67'),
(11, 2, 'Carlos Trejo', '85.67'),
(12, 3, 'Marques de la Montera', '85.00'),
(13, 4, 'Pato Jurasic', '99.00'),
(14, 5, 'Mondongo Completo', '70.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `carrera_id` bigint(20) UNSIGNED NOT NULL,
  `nombre_carrera` text NOT NULL,
  `plan_estudios` enum('mefi','meya') NOT NULL DEFAULT 'mefi'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`carrera_id`, `nombre_carrera`, `plan_estudios`) VALUES
(0, 'Ingeniería en Software', 'mefi'),
(1, 'Enseñanza de las matemáticas', 'mefi'),
(2, 'Actuaría', 'mefi'),
(3, 'Ciencias de la computación', 'mefi'),
(4, 'Ingeniería en computación', 'mefi'),
(5, 'Matemáticas', 'mefi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `comentario_id` bigint(20) UNSIGNED NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `semestre` text NOT NULL,
  `comentario` longtext NOT NULL,
  `calificacion` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`comentario_id`, `fecha_creacion`, `semestre`, `comentario`, `calificacion`) VALUES
(32, '2022-11-30 01:58:55', 'Ago-Dic 2022', 'No pos si se rifó', 90),
(33, '2022-11-30 06:13:05', 'Ago-Dic 2022', 'Pues al chile le falto', 80),
(34, '2022-11-30 06:18:42', 'Ago-Dic 2022', 'Pues ahí le fue masomenos', 87),
(35, '2022-11-30 06:24:48', 'Ago-Dic 2022', 'mehh', 90),
(36, '2022-11-30 06:45:22', 'Ago-Dic 2022', 'saquese', 50),
(37, '2022-11-30 11:43:50', 'Ago-Dic 2022', 'asdf', 32),
(38, '2022-11-30 11:47:41', 'Ago-Dic 2022', 'Ay no se estuvo bien', 90),
(39, '2022-11-30 11:51:54', 'Ago-Dic 2022', 'Ay no se estuvo bien', 100),
(40, '2022-11-30 12:06:26', 'Ago-Dic 2022', 'Me la suda', 90),
(41, '2022-11-30 12:06:45', 'Ago-Dic 2022', 'Yo que sé', 89),
(42, '2022-11-30 12:08:43', 'Ago-Dic 2022', 'Yo que sé', 89),
(43, '2022-11-30 12:10:58', 'Ago-Dic 2022', 'Holi', 89),
(44, '2022-11-30 12:11:21', 'Ago-Dic 2022', 'Hola again', 99),
(45, '2022-11-30 12:11:51', 'Ago-Dic 2022', 'Ñooooo', 89),
(46, '2022-11-30 12:14:04', 'Ago-Dic 2022', 'A ver que paso aqui', 77),
(1669812304, '2022-11-30 12:45:04', 'Ago-Dic 2022', 'Pikachu we', 78),
(1669812314, '2022-11-30 12:45:14', 'Ago-Dic 2022', 'Llala', 90),
(1669812325, '2022-11-30 12:45:25', 'Ago-Dic 2022', 'Mecanofonico', 89),
(1669832016, '2022-11-30 18:13:36', 'Ago-Dic 2022', 'Ejele', 80),
(1669832031, '2022-11-30 18:13:51', 'Ago-Dic 2022', 'Yuju', 90),
(1669832073, '2022-11-30 18:14:33', 'Ago-Dic 2022', 'Pus orale', 99),
(1669832107, '2022-11-30 18:15:07', 'Ago-Dic 2022', 'Allá tu', 70);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `cuenta_id` bigint(20) UNSIGNED NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `type_account` enum('admin','editor','user') NOT NULL DEFAULT 'user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`cuenta_id`, `email`, `password`, `type_account`) VALUES
(1, 'rodri@correo.com', 'contraseña', 'user'),
(2, 'gabo@correo.com', 'password', 'user'),
(3, 'hector@correo.com', 'password', 'user'),
(4, 'calci@correo.com', 'password', 'editor'),
(5, 'shao@correo.com', 'password', 'editor'),
(6, 'roderykmaliachi@gmail.com', 'password', 'admin'),
(7, 'a15000520@alumnos.uady.mx', 'asdf', 'user'),
(8, 'safo@correo.com', 'password', 'user'),
(9, 'roderyk@gmail.com', 'password', 'user'),
(10, 'correo@correo.com', 'asdf', 'editor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiquetas`
--

CREATE TABLE `etiquetas` (
  `etiqueta_id` bigint(20) UNSIGNED NOT NULL,
  `nombre_etiqueta` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `etiquetas`
--

INSERT INTO `etiquetas` (`etiqueta_id`, `nombre_etiqueta`) VALUES
(1, 'motivado'),
(2, 'amoroso'),
(3, 'grosero'),
(4, 'flojo'),
(5, 'deshonesto'),
(6, 'estudioso'),
(7, 'responsable'),
(8, 'puntual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiquetas_alumnos`
--

CREATE TABLE `etiquetas_alumnos` (
  `etiqueta_id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `etiquetas_alumnos`
--

INSERT INTO `etiquetas_alumnos` (`etiqueta_id`, `alumno_id`) VALUES
(1, 4),
(1, 6),
(1, 7),
(1, 8),
(1, 14),
(2, 4),
(2, 10),
(2, 14),
(3, 5),
(3, 8),
(3, 9),
(4, 4),
(5, 8),
(5, 9),
(5, 13),
(6, 6),
(6, 7),
(6, 10),
(6, 12),
(7, 4),
(7, 5),
(7, 8),
(7, 10),
(7, 12),
(8, 9),
(8, 13);

--
-- Disparadores `etiquetas_alumnos`
--
DELIMITER $$
CREATE TRIGGER `increment_count` AFTER UPDATE ON `etiquetas_alumnos` FOR EACH ROW UPDATE etiquetas_alumnos SET etiquetas_alumnos.cantidad = etiquetas_alumnos.cantidad+1
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiquetas_comentarios`
--

CREATE TABLE `etiquetas_comentarios` (
  `etiqueta_id` bigint(20) NOT NULL,
  `comentario_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `etiquetas_comentarios`
--

INSERT INTO `etiquetas_comentarios` (`etiqueta_id`, `comentario_id`) VALUES
(1, 32),
(1, 34),
(1, 35),
(1, 38),
(1, 39),
(1, 42),
(1, 1669832107),
(2, 32),
(2, 46),
(2, 1669832107),
(3, 37),
(3, 40),
(3, 43),
(4, 33),
(4, 36),
(5, 40),
(5, 43),
(5, 44),
(5, 1669832073),
(6, 38),
(6, 39),
(6, 44),
(6, 46),
(6, 1669832031),
(7, 32),
(7, 37),
(7, 42),
(7, 44),
(7, 1669832031),
(8, 44),
(8, 1669832073);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info_comentarios`
--

CREATE TABLE `info_comentarios` (
  `comentario_id` bigint(20) NOT NULL,
  `cuenta_id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `info_comentarios`
--

INSERT INTO `info_comentarios` (`comentario_id`, `cuenta_id`, `alumno_id`, `materia_id`) VALUES
(32, 1, 4, 1),
(33, 1, 4, 1),
(34, 1, 4, 1),
(35, 1, 4, 1),
(36, 1, 4, 1),
(37, 1, 5, 1),
(38, 1, 6, 1),
(39, 1, 7, 1),
(40, 1, 8, 1),
(42, 1, 8, 1),
(43, 1, 9, 1),
(44, 1, 9, 1),
(44, 1, 10, 1),
(46, 1, 10, 1),
(1669812304, 1, 11, 1),
(1669812314, 1, 11, 1),
(1669812325, 1, 11, 1),
(1669832016, 1, 12, 1),
(1669832031, 1, 12, 1),
(1669832073, 1, 13, 1),
(1669832107, 1, 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `materia_id` bigint(20) UNSIGNED NOT NULL,
  `nombre_materia` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`materia_id`, `nombre_materia`) VALUES
(1, 'Fundamentos de Ingeniería de Software');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias_carreras`
--

CREATE TABLE `materias_carreras` (
  `carrera_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL,
  `semestre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`alumno_id`),
  ADD UNIQUE KEY `carrera_id` (`carrera_id`,`nombre_alumno`) USING HASH;

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`carrera_id`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`comentario_id`),
  ADD UNIQUE KEY `fecha_creacion` (`fecha_creacion`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`cuenta_id`),
  ADD UNIQUE KEY `cuenta_id` (`cuenta_id`),
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- Indices de la tabla `etiquetas`
--
ALTER TABLE `etiquetas`
  ADD PRIMARY KEY (`etiqueta_id`);

--
-- Indices de la tabla `etiquetas_alumnos`
--
ALTER TABLE `etiquetas_alumnos`
  ADD UNIQUE KEY `etiqueta_id` (`etiqueta_id`,`alumno_id`);

--
-- Indices de la tabla `etiquetas_comentarios`
--
ALTER TABLE `etiquetas_comentarios`
  ADD UNIQUE KEY `etiqueta_id` (`etiqueta_id`,`comentario_id`);

--
-- Indices de la tabla `info_comentarios`
--
ALTER TABLE `info_comentarios`
  ADD UNIQUE KEY `comentario_id` (`comentario_id`,`cuenta_id`,`alumno_id`,`materia_id`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`materia_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `alumno_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `carrera_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `cuenta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `etiquetas`
--
ALTER TABLE `etiquetas`
  MODIFY `etiqueta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `materia_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-09-2010 a las 16:19:48
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdsistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--
create database bdsistema;
use bdsistema;

CREATE TABLE IF NOT EXISTS `categoria` (
  `nombre` varchar(25) NOT NULL,
  `detalle` varchar(100) not null unique,
  `codcateg` int NOT NULL AUTO_INCREMENT,
  `imagen` text,
  PRIMARY KEY (`codcateg`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`nombre`, `detalle`, `imagen`) VALUES
('AGUA','120ml','');
INSERT INTO `categoria` (`nombre`, `detalle`, `imagen`) VALUES
('AGUA','180ml','');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `nroEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `dni` char(8) NOT NULL unique,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(40) not NULL,
  `telefono` char(20) not NULL,
  `sexo` char(1) not NULL,
  `edad` int not NULL,
  `celular` varchar(20) not NULL,
  `imagen` text,
  PRIMARY KEY (`nroEmpleado`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nroEmpleado`, `nombre`, `apellido`, `dni`, `direccion`, `email`, `telefono`, `sexo`, `edad`, `celular`, `imagen`) VALUES
(1, 'Juan', 'Perez', '47197204', 'Psj Gar. de la Vega #138 - La Esperanza Parte Baja', 'tkcrashr.18@gmail.com', '(052)-276-985', 'M', 19, '(952)-948-589', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `idcompra` int NOT NULL auto_increment,
  `dniCliente` char(8) not null,
  `nroEmpleado` int NOT NULL,
  `fechaCompra` varchar(20) not NULL,
  `tipoCambio` varchar(10) not null,
  `montoTotal` float NOT NULL DEFAULT 0,
  estado varchar(20) not null,
  PRIMARY KEY (`idcompra`),
  foreign key (`nroEmpleado`) references empleado(`nroEmpleado`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `compra`
--

INSERT INTO `compra` (`idcompra`, `dniCliente`, `nroEmpleado`, `fechaCompra`,`tipoCambio`, `montoTotal`) VALUES
(1, '00326598', 1, '2010-08-30', 'DOLAR','14.75');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int not null AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `unidadmed` varchar(20) NOT NULL,
  `codcateg` int(11) not NULL,
  `preciounidad` float NOT NULL,
  `stock` int not null,
  `imagen` text,
  `codigo_barra` varchar(50) not null UNIQUE,
  primary key (`idProducto`),
  foreign key (`codcateg`) references categoria(`codcateg`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombre`, `unidadmed`, `codcateg`, `preciounidad`, stock, `imagen`,`codigo_barra`) VALUES
(1, 'AGUA MINERAL', 'mililitros', 1, 1.0, 20, '', '1234567895696');
INSERT INTO `producto` (`idProducto`, `nombre`, `unidadmed`, `codcateg`, `preciounidad`, stock, `imagen`,`codigo_barra`) VALUES
(2, 'AGUA MINERAL', 'mililitros', 2, 1.0, 20, '', '1234567895697');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE IF NOT EXISTS `transaccion` (
  `codigo_barra` varchar(50) NOT NULL,
  `idcompra` int NOT NULL,
  `cantidad` int NOT NULL,
  foreign key (`idcompra`) references compra(`idcompra`),
  foreign key (`codigo_barra`) references producto(`codigo_barra`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

insert into transaccion (`codigo_barra`,`idcompra`,`cantidad`) values ('1234567895696',1,1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL unique,
  nroEmpleado int not null,
  `contrasena` varchar(18) not NULL,
  tipoUsuario varchar(20) not null,
  PRIMARY KEY (`id`),
  foreign key (`nroEmpleado`) references empleado(`nroEmpleado`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `nroEmpleado`,contrasena,tipoUsuario) VALUES
(1, 'ADMINISTRADOR', 1, '123456','Administrador');

CREATE TABLE IF NOT EXISTS `caja` (
  `idCaja` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL unique,
  estado varchar(20) not null,
  PRIMARY KEY (`idCaja`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

insert into caja values(1,'DESKTOP-I3OKVOU','Activo');

CREATE TABLE IF NOT EXISTS `productoEsperaCliente` (
  id int not null auto_increment,
  `dniCliente` varchar(18) not NULL,
  idCaja int not null,
  estado varchar(20) not null,
  PRIMARY KEY (`id`),
  foreign key (`idCaja`) references caja(`idCaja`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `productoEsperaClienteDetalle` (
	id int not null AUTO_INCREMENT,
	idEspera int not null,
  `codigo_barra` varchar(13) NOT NULL,
  `dniCliente` varchar(18) not NULL,
  `cantidad` char(8) not NULL,
  primary key(id),
  foreign key (`idEspera`) references productoEsperaCliente(`id`),
  foreign key (`codigo_barra`) references producto(`codigo_barra`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

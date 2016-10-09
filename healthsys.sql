SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `healthsys` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `healthsys`;

DROP TABLE IF EXISTS `acesso_atendimentos`;
CREATE TABLE IF NOT EXISTS `acesso_atendimentos` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `atendimento_id` int(11) UNSIGNED NOT NULL,
  `medico_id` int(11) UNSIGNED NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `medico_fk` (`medico_id`),
  KEY `atendimento_fk` (`atendimento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `anexos`;
CREATE TABLE IF NOT EXISTS `anexos` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `atendimentos`;
CREATE TABLE IF NOT EXISTS `atendimentos` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `paciente_id` int(11) UNSIGNED NOT NULL,
  `data_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `titulo` varchar(255) NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `paciente_fk` (`paciente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `atendimentos` (`id`, `paciente_id`, `data_inicio`, `titulo`, `descricao`) VALUES
(1, 2, '2016-09-16 04:46:53', 'Dor de cabeça', 'Dor de cabeça muito forte iniciada hoje.');

DROP TABLE IF EXISTS `doencas`;
CREATE TABLE IF NOT EXISTS `doencas` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cid` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sintoma` varchar(255) NOT NULL,
  `causa` varchar(255) NOT NULL,
  `tratamento` varchar(255) NOT NULL,
  `patologia` varchar(255) NOT NULL,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `doencas_pacientes`;
CREATE TABLE IF NOT EXISTS `doencas_pacientes` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `doenca_id` int(11) UNSIGNED NOT NULL,
  `paciente_id` int(11) UNSIGNED NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `doenca_fk` (`doenca_id`),
  KEY `doencas_pacientes_fk` (`paciente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `respostas_atendimentos`;
CREATE TABLE IF NOT EXISTS `respostas_atendimentos` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `atendimento_id` int(11) UNSIGNED NOT NULL,
  `usuario_id` int(11) UNSIGNED NOT NULL,
  `data_resposta` timestamp NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `respostas_atendimentos_fk` (`atendimento_id`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `respostas_atendimentos` (`id`, `atendimento_id`, `usuario_id`, `data_resposta`, `titulo`, `descricao`) VALUES
(1, 1, 1, '2016-09-24 02:21:01', 'Primeira Consulta', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce urna metus, semper vel molestie sed, iaculis eget mauris. Mauris gravida libero non elit lacinia, id fringilla velit suscipit. Vestibulum augue nisl, finibus ac est nec, venenatis rutrum leo. Aenean vel dictum nunc, eget porta neque. Donec accumsan neque id nulla pellentesque auctor. Fusce nisl justo, convallis eget ante euismod, maximus eleifend lorem. Integer ac rutrum dui. Duis eget justo in orci placerat consequat ultrices quis ipsum. Donec venenatis diam vehicula odio ullamcorper, at cursus odio rhoncus. Aliquam non rutrum libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n\r\nAenean ac pretium lacus. Ut ornare aliquam purus, quis maximus lacus elementum nec. Etiam semper mauris quis augue interdum volutpat. Integer gravida pharetra diam eget finibus. Duis vel orci id ante iaculis faucibus non a ligula. Nulla pulvinar rutrum orci. Nulla tortor leo, dapibus at volutpat et, accumsan eget nunc. Nulla eu ipsum a est fermentum rutrum sed eu magna. Pellentesque porttitor imperdiet est vel lobortis.\r\n\r\nAliquam vel feugiat justo, et sollicitudin nunc. Nulla finibus elit euismod purus iaculis varius. Vestibulum bibendum dui sed quam vehicula convallis. Ut risus erat, vestibulum ullamcorper iaculis et, congue at libero. Nam vel orci a risus consequat vulputate. Duis a elementum ex. In gravida tortor et aliquet malesuada. Nunc consequat, magna eu rutrum viverra, sapien ipsum venenatis diam, in fermentum nulla nulla eu neque. Phasellus vel velit quis eros condimentum bibendum a nec erat.'),
(2, 1, 2, '2016-09-24 02:21:20', 'Lorem Ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris varius dui nec lacinia rhoncus. Nulla laoreet augue eget eros aliquet lobortis. Fusce pharetra dapibus sagittis. Maecenas posuere varius tellus vitae porttitor. In a justo neque. Fusce ut elementum orci. Aliquam pretium, felis eu facilisis volutpat, dui orci tempor sem, ut malesuada elit arcu et sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque et lacinia nulla. Nunc eu purus velit. Sed quis vestibulum nisi.\r\n\r\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Ut libero mi, tempus eget justo ut, pellentesque ullamcorper est. Ut laoreet in urna sit amet faucibus. Morbi orci arcu, fermentum quis aliquet id, posuere ac nunc. Fusce vitae tellus arcu. Nam mauris leo, dapibus rhoncus euismod nec, mollis sed lacus. Fusce fermentum libero ac odio tempor, sit amet consectetur nunc imperdiet. In hac habitasse platea dictumst. Vestibulum dolor velit, rutrum quis quam posuere, pharetra scelerisque neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce suscipit turpis ac turpis mollis laoreet. Fusce at eros pellentesque, dignissim sem vitae, malesuada erat. Quisque lacus nisl, porttitor vel metus facilisis, dignissim aliquam dui. Nulla pulvinar consectetur massa eu feugiat.\r\n\r\nDonec varius quam ac mauris suscipit, nec lacinia velit tristique. Etiam lacinia purus ut lorem tempor bibendum. Aenean non semper odio. Etiam sed eleifend nisl. Maecenas hendrerit euismod facilisis. Morbi gravida non ligula a commodo. Sed vulputate lacinia arcu auctor lacinia. Nulla eget semper lectus. Morbi id molestie neque, et dignissim velit. Duis eget arcu eu nisl sollicitudin malesuada sed vitae ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),
(3, 1, 1, '2016-09-24 02:21:57', 'Lovel molestie sed', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce urna metus, semper vel molestie sed, iaculis eget mauris.\r\n\r\nAenean ac pretium lacus. Ut ornare aliquam purus, quis maximus lacus elementum nec. Etiam semper mauris quis augue interdum volutpat. Integer gravida pharetra diam eget finibus. Duis vel orci id ante iaculis faucibus non a ligula. Nulla pulvinar rutrum orci. Nulla tortor leo, dapibus at volutpat et, accumsan eget nunc. Nulla eu ipsum a est fermentum rutrum sed eu magna. Pellentesque porttitor imperdiet est vel lobortis.\r\n\r\nAliquam vel feugiat justo, et sollicitudin nunc. Nulla finibus elit euismod purus iaculis varius. Vestibulum bibendum dui sed quam vehicula convallis. Ut risus erat, vestibulum ullamcorper iaculis et, congue at libero. Nam vel orci a risus consequat vulputate. Duis a elementum ex. In gravida tortor et aliquet malesuada. Nunc consequat, magna eu rutrum viverra, sapien ipsum venenatis diam, in fermentum nulla nulla eu neque. Phasellus vel velit quis eros condimentum bibendum a nec erat.'),
(4, 1, 2, '2016-09-24 02:21:57', 'Lorem Ipsum', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque et lacinia nulla. Nunc eu purus velit. Sed quis vestibulum nisi.\r\n');

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL DEFAULT 'MASCULINO',
  `tipo_sanguineo` varchar(255) NOT NULL DEFAULT 'A_NEGATIVO',
  `data_nascimento` date DEFAULT NULL,
  `telefone` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `observacoes` text NOT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `usuarios` (`id`, `login`, `senha`, `email`, `nome`, `sexo`, `tipo_sanguineo`, `data_nascimento`, `telefone`, `estado`, `cidade`, `cep`, `observacoes`, `role`) VALUES
(1, 'admin', 'admin', 'admin@exemplo.com', 'Administrador Exemplo', 'MASCULINO', 'A_NEGATIVO', '1990-04-07', '5199999999', 'Rio Grande do Sul', 'Porto Alegre', '91440160', 'Alérgico à amoxilina', 'ADMIN'),
(2, 'usuario', 'usuario', 'usuario@exemplo.com', 'Usuário Exemplo', 'FEMININO', 'AB_POSITIVO', '1975-07-11', '5199999999', 'São Paulo', 'São Paulo', '90111153', '', 'USER'),
(3, 'medico', 'medico', 'medico@exemplo.com', 'Médico Exemplo', 'MASCULINO', 'O_NEGATIVO', '1975-04-07', '5199999999', 'Rio Grande do Sul', 'Porto Alegre', '91440160', 'Alérgico à amoxilina', 'MEDIC'),
(4, 'usuario2', 'usuario2', 'usuario2@exemplo.com', 'Usuário Exemplo 2', 'MASCULINO', 'A_POSITIVO', '1985-07-11', '5199999999', 'São Paulo', 'São Paulo', '90111153', 'Teste', 'USER'),
(5, 'medico2', 'medico2', 'medico2@exemplo.com', 'Médico Exemplo 2', 'FEMININO', 'AB_NEGATIVO', '1992-04-07', '5199999999', 'Rio Grande do Sul', 'Porto Alegre', '91440160', '', 'MEDIC');


ALTER TABLE `acesso_atendimentos`
  ADD CONSTRAINT `atendimento_fk` FOREIGN KEY (`atendimento_id`) REFERENCES `atendimentos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `medico_fk` FOREIGN KEY (`medico_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `atendimentos`
  ADD CONSTRAINT `paciente_fk` FOREIGN KEY (`paciente_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `doencas_pacientes`
  ADD CONSTRAINT `doenca_fk` FOREIGN KEY (`doenca_id`) REFERENCES `doencas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `doencas_pacientes_fk` FOREIGN KEY (`paciente_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `respostas_atendimentos`
  ADD CONSTRAINT `respostas_atendimentos_fk` FOREIGN KEY (`atendimento_id`) REFERENCES `atendimentos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respostas_atendimentos_fk2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

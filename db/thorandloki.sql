-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Nov-2022 às 19:16
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `thorandloki`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `alun_id` int(11) NOT NULL,
  `alun_nome` varchar(50) NOT NULL,
  `alun_cpf` varchar(15) NOT NULL,
  `alun_idade` int(3) DEFAULT NULL,
  `alun_mensalidade` decimal(10,2) NOT NULL,
  `alun_multa` decimal(10,2) DEFAULT NULL,
  `alun_endereco` text DEFAULT NULL,
  `alun_telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convidados`
--

CREATE TABLE `convidados` (
  `conv_id` int(11) NOT NULL,
  `conv_nome` varchar(50) NOT NULL,
  `conv_cpf` varchar(15) NOT NULL,
  `conv_valor` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `func_id` int(11) NOT NULL,
  `func_nome` varchar(50) NOT NULL,
  `func_salario` decimal(10,2) NOT NULL,
  `func_funcao` varchar(50) DEFAULT NULL,
  `func_endereco` text DEFAULT NULL,
  `func_telefone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `prof_id` int(11) NOT NULL,
  `prof_nome` varchar(50) NOT NULL,
  `prof_cpf` varchar(15) NOT NULL,
  `prof_salario` decimal(10,2) DEFAULT NULL,
  `prof_endereco` text DEFAULT NULL,
  `prof_telefone` varchar(20) DEFAULT NULL,
  `prof_horas` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`alun_id`),
  ADD UNIQUE KEY `alun_cpf` (`alun_cpf`);

--
-- Índices para tabela `convidados`
--
ALTER TABLE `convidados`
  ADD PRIMARY KEY (`conv_id`),
  ADD UNIQUE KEY `conv_cpf` (`conv_cpf`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`func_id`);

--
-- Índices para tabela `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`prof_id`),
  ADD UNIQUE KEY `prof_cpf` (`prof_cpf`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alunos`
--
ALTER TABLE `alunos`
  MODIFY `alun_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `convidados`
--
ALTER TABLE `convidados`
  MODIFY `conv_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `func_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `professores`
--
ALTER TABLE `professores`
  MODIFY `prof_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

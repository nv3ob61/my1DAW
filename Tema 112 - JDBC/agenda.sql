SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Agenda` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `Agenda` ;

-- -----------------------------------------------------
-- Table `Agenda`.`Modulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Modulo` (
  `id` INT NOT NULL ,
  `acronimo` VARCHAR(10) NULL ,
  `nombre` VARCHAR(50) NULL ,
  `codigo` VARCHAR(10) NULL ,
  `horasCurso` INT NULL ,
  `curso` INT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Ciclo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Ciclo` (
  `id` INT NOT NULL ,
  `acronimo` VARCHAR(10) NULL ,
  `nombre` VARCHAR(50) NULL ,
  `codigo` VARCHAR(10) NULL ,
  `grado` VARCHAR(20) NULL ,
  `familia` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`CicloModulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`CicloModulo` (
  `modulo` INT NOT NULL ,
  `ciclo` INT NOT NULL ,
  PRIMARY KEY (`modulo`, `ciclo`) ,
  INDEX `fk_ModuloCiclo_Ciclo1` (`ciclo` ASC) ,
  INDEX `fk_ModuloCiclo_Modulo1` (`modulo` ASC) ,
  CONSTRAINT `fk_ModuloCiclo_Modulo1`
    FOREIGN KEY (`modulo` )
    REFERENCES `Agenda`.`Modulo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ModuloCiclo_Ciclo1`
    FOREIGN KEY (`ciclo` )
    REFERENCES `Agenda`.`Ciclo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Grupo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Grupo` (
  `id` INT NOT NULL ,
  `acronimo` VARCHAR(10) NULL ,
  `codigo` VARCHAR(10) NULL ,
  `turno` VARCHAR(20) NULL ,
  `aula` VARCHAR(20) NULL ,
  `anyEscolar` VARCHAR(10) NULL ,
  `ciclo` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Grupo_Ciclo1` (`ciclo` ASC) ,
  CONSTRAINT `fk_Grupo_Ciclo1`
    FOREIGN KEY (`ciclo` )
    REFERENCES `Agenda`.`Ciclo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Alumno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Alumno` (
  `exp` VARCHAR(10) NOT NULL ,
  `nombre` VARCHAR(50) NULL ,
  `apellidos` VARCHAR(50) NULL ,
  `nif` VARCHAR(20) NULL ,
  `nac` DATE NULL ,
  `telefono` VARCHAR(20) NULL ,
  `email` VARCHAR(50) NULL ,
  `domicilio` VARCHAR(50) NULL ,
  `localidad` VARCHAR(50) NULL ,
  `provincia` VARCHAR(50) NULL ,
  `cp` VARCHAR(10) NULL ,
  `user` VARCHAR(50) NULL ,
  `pass` VARCHAR(50) NULL ,
  `foto` BLOB NULL ,
  PRIMARY KEY (`exp`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Profesor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Profesor` (
  `id` INT NOT NULL ,
  `nombre` VARCHAR(50) NULL ,
  `apellidos` VARCHAR(50) NULL ,
  `departamento` VARCHAR(50) NULL ,
  `especialidad` VARCHAR(50) NULL ,
  `tipo` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Docencia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Docencia` (
  `id` INT NOT NULL ,
  `profesor` INT NULL ,
  `modulo` INT NULL ,
  `grupo` INT NULL ,
  `anyEscolar` VARCHAR(10) NULL ,
  `horasSemana` INT NULL ,
  `aula` VARCHAR(50) NULL ,
  INDEX `fk_Docencia_Modulo1` (`modulo` ASC) ,
  INDEX `fk_Docencia_Profesor1` (`profesor` ASC) ,
  INDEX `fk_Docencia_Grupo1` (`grupo` ASC) ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_Docencia_Profesor1`
    FOREIGN KEY (`profesor` )
    REFERENCES `Agenda`.`Profesor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Docencia_Modulo1`
    FOREIGN KEY (`modulo` )
    REFERENCES `Agenda`.`Modulo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Docencia_Grupo1`
    FOREIGN KEY (`grupo` )
    REFERENCES `Agenda`.`Grupo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Matricula`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Matricula` (
  `id` INT NOT NULL ,
  `codigo` INT NULL ,
  `docencia` INT NOT NULL ,
  `alumno` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Matricula_Alumno1` (`alumno` ASC) ,
  INDEX `fk_Matricula_Docencia1` (`docencia` ASC) ,
  CONSTRAINT `fk_Matricula_Docencia1`
    FOREIGN KEY (`docencia` )
    REFERENCES `Agenda`.`Docencia` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_Alumno1`
    FOREIGN KEY (`alumno` )
    REFERENCES `Agenda`.`Alumno` (`exp` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Calificacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Calificacion` (
  `id` INT NOT NULL ,
  `matricula` INT NOT NULL ,
  `concepto` VARCHAR(50) NULL ,
  `evaluación` INT NULL ,
  `valorInicial` INT NULL ,
  `ponderacion` INT NULL ,
  `valorFinal` INT NULL ,
  `etiqueta` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Calificacion_Matricula1` (`matricula` ASC) ,
  CONSTRAINT `fk_Calificacion_Matricula1`
    FOREIGN KEY (`matricula` )
    REFERENCES `Agenda`.`Matricula` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Segmento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Segmento` (
  `id` INT NOT NULL ,
  `numero` INT NULL ,
  `inicio` TIME NULL ,
  `finalizacion` TIME NULL ,
  `tipo` VARCHAR(20) NULL ,
  `turno` VARCHAR(20) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Horario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Horario` (
  `id` INT NOT NULL ,
  `segmento` INT NOT NULL ,
  `docencia` INT NOT NULL ,
  INDEX `fk_Horario_Segmento1` (`segmento` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Horario_Docencia1` (`docencia` ASC) ,
  CONSTRAINT `fk_Horario_Hora1`
    FOREIGN KEY (`segmento` )
    REFERENCES `Agenda`.`Segmento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_Docencia1`
    FOREIGN KEY (`docencia` )
    REFERENCES `Agenda`.`Docencia` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agenda`.`Actividad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agenda`.`Actividad` (
  `id` INT NOT NULL ,
  `descripcion` VARCHAR(50) NULL ,
  `docencia` INT NOT NULL ,
  `segmento` INT NOT NULL ,
  `fecha` DATE NULL ,
  `duracion` INT NULL ,
  `tipo` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Actividad_Docencia1` (`docencia` ASC) ,
  INDEX `fk_Actividad_Hora1` (`segmento` ASC) ,
  CONSTRAINT `fk_Actividad_Docencia1`
    FOREIGN KEY (`docencia` )
    REFERENCES `Agenda`.`Docencia` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Actividad_Hora1`
    FOREIGN KEY (`segmento` )
    REFERENCES `Agenda`.`Segmento` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

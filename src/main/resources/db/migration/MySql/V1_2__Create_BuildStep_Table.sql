CREATE TABLE IF NOT EXISTS `BuildStep` (
  `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  `name` VARCHAR(250) NOT NULL,
  `jobId` INT NOT NULL,
  `buildTypeId` INT NOT NULL,
  `orderValue` INT NOT NULL,
  `isDisabled` BIT(1) NOT NULL,
  `createdDateUtc` DATETIME NOT NULL,
  `updatedDateUtc` DATETIME NOT NULL,
  `deletedDateUtc` DATETIME NULL,
  FOREIGN KEY (jobId) REFERENCES `Job` (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
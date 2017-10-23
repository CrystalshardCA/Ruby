IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = N'dbo' AND TABLE_NAME = N'Job')
BEGIN

    CREATE TABLE [dbo].[Job] (
        [id] [int] IDENTITY(1,1) NOT NULL,
        [name] [varchar](200) NOT NULL,
        [createdDateUtc] [datetime] NOT NULL,
        [updatedDateUtc] [datetime] NOT NULL,
        [deletedDateUtc] [datetime] NULL
     CONSTRAINT [UC_Job_id] UNIQUE NONCLUSTERED
     (
        [id] ASC
     ) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 90) ON [PRIMARY]
    ) ON [PRIMARY]

    ALTER TABLE [dbo].[Job] ADD
        CONSTRAINT DF_Job_createdDateUtc DEFAULT (getutcdate()) FOR [createdDateUtc],
        CONSTRAINT DF_Job_updatedDateUtc DEFAULT (getutcdate()) FOR [updatedDateUTc]

END
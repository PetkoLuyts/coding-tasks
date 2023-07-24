CREATE PROCEDURE CopyRecordsWithNoDuplicates
    @sourceDatabaseName NVARCHAR(100),
    @destinationDatabaseName NVARCHAR(100)
AS
BEGIN
    DECLARE @tableName NVARCHAR(100)
    DECLARE @sqlCommand NVARCHAR(MAX)
    DECLARE @sourceFirstColumn NVARCHAR(MAX)
    DECLARE @destinationFirstColumn NVARCHAR(MAX)
    DECLARE tableCursor CURSOR FOR
    SELECT TABLE_NAME
    FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_TYPE = 'BASE TABLE'
    AND TABLE_CATALOG = @sourceDatabaseName
    OPEN tableCursor
    FETCH NEXT FROM tableCursor INTO @tableName
    -- Loop through each table and copy records
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Get the column names for the insert statement
        DECLARE @insertColumns NVARCHAR(MAX) = ''
        DECLARE @selectColumns NVARCHAR(MAX) = ''
        SELECT @insertColumns += QUOTENAME(COLUMN_NAME) + ','
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_SCHEMA = N'dbo' -- Replace with the appropriate schema name of the destination table
            AND TABLE_NAME = @tableName -- Assuming @tableName contains the name of the source table
        ORDER BY ORDINAL_POSITION;
        SELECT @selectColumns += QUOTENAME(COLUMN_NAME) + ','
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_SCHEMA = N'dbo' -- Replace with the appropriate schema name of the source table
            AND TABLE_NAME = @tableName -- Assuming @destinationTableName contains the name of the destination table
        ORDER BY ORDINAL_POSITION;
        SET @insertColumns = LEFT(@insertColumns, LEN(@insertColumns) - 1)
        SET @selectColumns = LEFT(@selectColumns, LEN(@selectColumns) - 1)
        SELECT TOP 1 @destinationFirstColumn = COLUMN_NAME
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_SCHEMA = N'dbo' -- Replace with the appropriate schema name of the destination table
            AND TABLE_NAME = @tableName -- Assuming @destinationTableName contains the name of the destination table
        ORDER BY ORDINAL_POSITION;
        SELECT TOP 1 @sourceFirstColumn = COLUMN_NAME
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_SCHEMA = N'dbo' -- Replace with the appropriate schema name of the source table
            AND TABLE_NAME = @tableName -- Assuming @tableName contains the name of the source table
        ORDER BY ORDINAL_POSITION;
        SET @sqlCommand = N'
        INSERT INTO ' + QUOTENAME(@destinationDatabaseName) + N'.dbo.' + QUOTENAME(@tableName) + N' (' + @insertColumns + ')
        SELECT ' + @selectColumns + '
        FROM ' + QUOTENAME(@sourceDatabaseName) + N'.dbo.' + QUOTENAME(@tableName) + N' AS Source
        WHERE NOT EXISTS (
            SELECT 1
            FROM ' + QUOTENAME(@destinationDatabaseName) + N'.dbo.' + QUOTENAME(@tableName) + N' AS Target
            WHERE ' + QUOTENAME(@destinationFirstColumn) + N' = Source.' + QUOTENAME(@sourceFirstColumn) + N'
        );';
        EXEC sp_executesql @sqlCommand;
        FETCH NEXT FROM tableCursor INTO @tableName
    END
    CLOSE tableCursor
    DEALLOCATE tableCursor
END
EXEC CopyRecordsWithNoDuplicates 'Adeptia_Connect_Old', 'Adeptia_Connect_Clean';
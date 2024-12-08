package dialect;

import org.hibernate.dialect.Dialect;

@SuppressWarnings("deprecation")
public class SQLDialect extends Dialect {
//    public SQLDialect() {}

	public boolean supportsIdentityColumns() {
		return true;
	}

	public boolean hasDataTypeInIdentityColumn() {
		return false; // As specify in NHibernate dialect
	}

	public String getIdentityColumnString() {
		// return "integer primary key autoincrement";
		return "integer";
	}

	public String getIdentitySelectString() {
		return "select last_insert_rowid()";
	}

	public boolean supportsLimit() {
		return true;
	}

	protected String getLimitString(String query, boolean hasOffset) {
		return new StringBuffer(query.length() + 20).append(query).append(hasOffset ? " limit ? offset ?" : " limit ?")
				.toString();
	}

	@Override
	public boolean supportsTemporaryTables() {
		return true;
	}

	public String getCreateTemporaryTableString() {
		return "create temporary table if not exists";
	}

	public boolean dropTemporaryTableAfterUse() {
		return false;
	}

	@Override
	public boolean supportsCurrentTimestampSelection() {
		return true;
	}

	@Override
	public boolean isCurrentTimestampSelectStringCallable() {
		return false;
	}

	@Override
	public String getCurrentTimestampSelectString() {
		return "select current_timestamp";
	}

	@Override
	public boolean supportsUnionAll() {
		return true;
	}

	@Override
	public boolean hasAlterTable() {
		return false; // As specify in NHibernate dialect
	}

	@Override
	public boolean dropConstraints() {
		return false;
	}

	@Override
	public String getAddColumnString() {
		return "add column";
	}

	@Override
	public String getForUpdateString() {
		return "";
	}

	@Override
	public boolean supportsOuterJoinForUpdate() {
		return false;
	}

	@Override
	public String getDropForeignKeyString() {
		throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
	}

	@Override
	public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
			String[] primaryKey, boolean referencesPrimaryKey) {
		throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
	}

	@Override
	public String getAddPrimaryKeyConstraintString(String constraintName) {
		throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
	}

	@Override
	public boolean supportsIfExistsBeforeTableName() {
		return true;
	}

	@Override
	public boolean supportsCascadeDelete() {
		return false;
	}
}
package com.mchange.v2.c3p0.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.sql.SqlUtils;

public final class NewProxyDatabaseMetaData implements DatabaseMetaData {
	class NewProxyDatabaseMetaDataConnectionEventListener implements ConnectionEventListener {
		private NewProxyDatabaseMetaData newProxyDatabaseMetaData;

		NewProxyDatabaseMetaDataConnectionEventListener(NewProxyDatabaseMetaData newProxyDatabaseMetaData) {
			this.newProxyDatabaseMetaData = newProxyDatabaseMetaData;
		}

		public void connectionErrorOccurred(ConnectionEvent evt) {
		}

		public void connectionClosed(ConnectionEvent evt) {
			// TODO Auto-generated method stub
		}
	}

	protected DatabaseMetaData inner;
	private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyDatabaseMetaData");
	volatile NewPooledConnection parentPooledConnection;
	ConnectionEventListener cel;
	NewProxyConnection proxyCon;

	public NewProxyDatabaseMetaData(DatabaseMetaData inner) {
		this.cel = new NewProxyDatabaseMetaDataConnectionEventListener(this);
		this.inner = inner;
	}

	public final int getResultSetHoldability() throws SQLException {
		try {
			return this.inner.getResultSetHoldability();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean allProceduresAreCallable() throws SQLException {
		try {
			return this.inner.allProceduresAreCallable();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean allTablesAreSelectable() throws SQLException {
		try {
			return this.inner.allTablesAreSelectable();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean nullsAreSortedHigh() throws SQLException {
		try {
			return this.inner.nullsAreSortedHigh();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean nullsAreSortedLow() throws SQLException {
		try {
			return this.inner.nullsAreSortedLow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean nullsAreSortedAtStart() throws SQLException {
		try {
			return this.inner.nullsAreSortedAtStart();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean nullsAreSortedAtEnd() throws SQLException {
		try {
			return this.inner.nullsAreSortedAtEnd();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getDatabaseProductName() throws SQLException {
		try {
			return this.inner.getDatabaseProductName();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getDatabaseProductVersion() throws SQLException {
		try {
			return this.inner.getDatabaseProductVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getDriverName() throws SQLException {
		try {
			return this.inner.getDriverName();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getDriverVersion() throws SQLException {
		try {
			return this.inner.getDriverVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getDriverMajorVersion() {
		return this.inner.getDriverMajorVersion();
	}

	public final int getDriverMinorVersion() {
		return this.inner.getDriverMinorVersion();
	}

	public final boolean usesLocalFiles() throws SQLException {
		try {
			return this.inner.usesLocalFiles();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean usesLocalFilePerTable() throws SQLException {
		try {
			return this.inner.usesLocalFilePerTable();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMixedCaseIdentifiers() throws SQLException {
		try {
			return this.inner.supportsMixedCaseIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesUpperCaseIdentifiers() throws SQLException {
		try {
			return this.inner.storesUpperCaseIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesLowerCaseIdentifiers() throws SQLException {
		try {
			return this.inner.storesLowerCaseIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesMixedCaseIdentifiers() throws SQLException {
		try {
			return this.inner.storesMixedCaseIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
		try {
			return this.inner.supportsMixedCaseQuotedIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
		try {
			return this.inner.storesUpperCaseQuotedIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
		try {
			return this.inner.storesLowerCaseQuotedIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
		try {
			return this.inner.storesMixedCaseQuotedIdentifiers();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getIdentifierQuoteString() throws SQLException {
		try {
			return this.inner.getIdentifierQuoteString();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getSQLKeywords() throws SQLException {
		try {
			return this.inner.getSQLKeywords();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getNumericFunctions() throws SQLException {
		try {
			return this.inner.getNumericFunctions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getStringFunctions() throws SQLException {
		try {
			return this.inner.getStringFunctions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getSystemFunctions() throws SQLException {
		try {
			return this.inner.getSystemFunctions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getTimeDateFunctions() throws SQLException {
		try {
			return this.inner.getTimeDateFunctions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getSearchStringEscape() throws SQLException {
		try {
			return this.inner.getSearchStringEscape();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getExtraNameCharacters() throws SQLException {
		try {
			return this.inner.getExtraNameCharacters();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsAlterTableWithAddColumn() throws SQLException {
		try {
			return this.inner.supportsAlterTableWithAddColumn();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsAlterTableWithDropColumn() throws SQLException {
		try {
			return this.inner.supportsAlterTableWithDropColumn();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsColumnAliasing() throws SQLException {
		try {
			return this.inner.supportsColumnAliasing();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean nullPlusNonNullIsNull() throws SQLException {
		try {
			return this.inner.nullPlusNonNullIsNull();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsConvert() throws SQLException {
		try {
			return this.inner.supportsConvert();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsConvert(int a, int b) throws SQLException {
		try {
			return this.inner.supportsConvert(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg3);
			} else {
				throw arg3;
			}
		} catch (Exception arg4) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg4);
			} else {
				throw SqlUtils.toSQLException(arg4);
			}
		}
	}

	public final boolean supportsTableCorrelationNames() throws SQLException {
		try {
			return this.inner.supportsTableCorrelationNames();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsDifferentTableCorrelationNames() throws SQLException {
		try {
			return this.inner.supportsDifferentTableCorrelationNames();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsExpressionsInOrderBy() throws SQLException {
		try {
			return this.inner.supportsExpressionsInOrderBy();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOrderByUnrelated() throws SQLException {
		try {
			return this.inner.supportsOrderByUnrelated();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsGroupBy() throws SQLException {
		try {
			return this.inner.supportsGroupBy();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsGroupByUnrelated() throws SQLException {
		try {
			return this.inner.supportsGroupByUnrelated();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsGroupByBeyondSelect() throws SQLException {
		try {
			return this.inner.supportsGroupByBeyondSelect();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsLikeEscapeClause() throws SQLException {
		try {
			return this.inner.supportsLikeEscapeClause();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMultipleResultSets() throws SQLException {
		try {
			return this.inner.supportsMultipleResultSets();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMultipleTransactions() throws SQLException {
		try {
			return this.inner.supportsMultipleTransactions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsNonNullableColumns() throws SQLException {
		try {
			return this.inner.supportsNonNullableColumns();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMinimumSQLGrammar() throws SQLException {
		try {
			return this.inner.supportsMinimumSQLGrammar();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCoreSQLGrammar() throws SQLException {
		try {
			return this.inner.supportsCoreSQLGrammar();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsExtendedSQLGrammar() throws SQLException {
		try {
			return this.inner.supportsExtendedSQLGrammar();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsANSI92EntryLevelSQL() throws SQLException {
		try {
			return this.inner.supportsANSI92EntryLevelSQL();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsANSI92IntermediateSQL() throws SQLException {
		try {
			return this.inner.supportsANSI92IntermediateSQL();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsANSI92FullSQL() throws SQLException {
		try {
			return this.inner.supportsANSI92FullSQL();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsIntegrityEnhancementFacility() throws SQLException {
		try {
			return this.inner.supportsIntegrityEnhancementFacility();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOuterJoins() throws SQLException {
		try {
			return this.inner.supportsOuterJoins();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsFullOuterJoins() throws SQLException {
		try {
			return this.inner.supportsFullOuterJoins();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsLimitedOuterJoins() throws SQLException {
		try {
			return this.inner.supportsLimitedOuterJoins();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getSchemaTerm() throws SQLException {
		try {
			return this.inner.getSchemaTerm();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getProcedureTerm() throws SQLException {
		try {
			return this.inner.getProcedureTerm();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getCatalogTerm() throws SQLException {
		try {
			return this.inner.getCatalogTerm();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean isCatalogAtStart() throws SQLException {
		try {
			return this.inner.isCatalogAtStart();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getCatalogSeparator() throws SQLException {
		try {
			return this.inner.getCatalogSeparator();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSchemasInDataManipulation() throws SQLException {
		try {
			return this.inner.supportsSchemasInDataManipulation();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSchemasInProcedureCalls() throws SQLException {
		try {
			return this.inner.supportsSchemasInProcedureCalls();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSchemasInTableDefinitions() throws SQLException {
		try {
			return this.inner.supportsSchemasInTableDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSchemasInIndexDefinitions() throws SQLException {
		try {
			return this.inner.supportsSchemasInIndexDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
		try {
			return this.inner.supportsSchemasInPrivilegeDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCatalogsInDataManipulation() throws SQLException {
		try {
			return this.inner.supportsCatalogsInDataManipulation();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCatalogsInProcedureCalls() throws SQLException {
		try {
			return this.inner.supportsCatalogsInProcedureCalls();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCatalogsInTableDefinitions() throws SQLException {
		try {
			return this.inner.supportsCatalogsInTableDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCatalogsInIndexDefinitions() throws SQLException {
		try {
			return this.inner.supportsCatalogsInIndexDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
		try {
			return this.inner.supportsCatalogsInPrivilegeDefinitions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsPositionedDelete() throws SQLException {
		try {
			return this.inner.supportsPositionedDelete();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsPositionedUpdate() throws SQLException {
		try {
			return this.inner.supportsPositionedUpdate();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSelectForUpdate() throws SQLException {
		try {
			return this.inner.supportsSelectForUpdate();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsStoredProcedures() throws SQLException {
		try {
			return this.inner.supportsStoredProcedures();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSubqueriesInComparisons() throws SQLException {
		try {
			return this.inner.supportsSubqueriesInComparisons();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSubqueriesInExists() throws SQLException {
		try {
			return this.inner.supportsSubqueriesInExists();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSubqueriesInIns() throws SQLException {
		try {
			return this.inner.supportsSubqueriesInIns();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsSubqueriesInQuantifieds() throws SQLException {
		try {
			return this.inner.supportsSubqueriesInQuantifieds();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsCorrelatedSubqueries() throws SQLException {
		try {
			return this.inner.supportsCorrelatedSubqueries();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsUnion() throws SQLException {
		try {
			return this.inner.supportsUnion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsUnionAll() throws SQLException {
		try {
			return this.inner.supportsUnionAll();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOpenCursorsAcrossCommit() throws SQLException {
		try {
			return this.inner.supportsOpenCursorsAcrossCommit();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOpenCursorsAcrossRollback() throws SQLException {
		try {
			return this.inner.supportsOpenCursorsAcrossRollback();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOpenStatementsAcrossCommit() throws SQLException {
		try {
			return this.inner.supportsOpenStatementsAcrossCommit();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsOpenStatementsAcrossRollback() throws SQLException {
		try {
			return this.inner.supportsOpenStatementsAcrossRollback();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxBinaryLiteralLength() throws SQLException {
		try {
			return this.inner.getMaxBinaryLiteralLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxCharLiteralLength() throws SQLException {
		try {
			return this.inner.getMaxCharLiteralLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnNameLength() throws SQLException {
		try {
			return this.inner.getMaxColumnNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnsInGroupBy() throws SQLException {
		try {
			return this.inner.getMaxColumnsInGroupBy();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnsInIndex() throws SQLException {
		try {
			return this.inner.getMaxColumnsInIndex();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnsInOrderBy() throws SQLException {
		try {
			return this.inner.getMaxColumnsInOrderBy();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnsInSelect() throws SQLException {
		try {
			return this.inner.getMaxColumnsInSelect();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxColumnsInTable() throws SQLException {
		try {
			return this.inner.getMaxColumnsInTable();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxConnections() throws SQLException {
		try {
			return this.inner.getMaxConnections();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxCursorNameLength() throws SQLException {
		try {
			return this.inner.getMaxCursorNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxIndexLength() throws SQLException {
		try {
			return this.inner.getMaxIndexLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxSchemaNameLength() throws SQLException {
		try {
			return this.inner.getMaxSchemaNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxProcedureNameLength() throws SQLException {
		try {
			return this.inner.getMaxProcedureNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxCatalogNameLength() throws SQLException {
		try {
			return this.inner.getMaxCatalogNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxRowSize() throws SQLException {
		try {
			return this.inner.getMaxRowSize();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
		try {
			return this.inner.doesMaxRowSizeIncludeBlobs();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxStatementLength() throws SQLException {
		try {
			return this.inner.getMaxStatementLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxStatements() throws SQLException {
		try {
			return this.inner.getMaxStatements();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxTableNameLength() throws SQLException {
		try {
			return this.inner.getMaxTableNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxTablesInSelect() throws SQLException {
		try {
			return this.inner.getMaxTablesInSelect();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getMaxUserNameLength() throws SQLException {
		try {
			return this.inner.getMaxUserNameLength();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getDefaultTransactionIsolation() throws SQLException {
		try {
			return this.inner.getDefaultTransactionIsolation();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsTransactions() throws SQLException {
		try {
			return this.inner.supportsTransactions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsTransactionIsolationLevel(int a) throws SQLException {
		try {
			return this.inner.supportsTransactionIsolationLevel(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
		try {
			return this.inner.supportsDataDefinitionAndDataManipulationTransactions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsDataManipulationTransactionsOnly() throws SQLException {
		try {
			return this.inner.supportsDataManipulationTransactionsOnly();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean dataDefinitionCausesTransactionCommit() throws SQLException {
		try {
			return this.inner.dataDefinitionCausesTransactionCommit();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean dataDefinitionIgnoredInTransactions() throws SQLException {
		try {
			return this.inner.dataDefinitionIgnoredInTransactions();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getProcedures(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getProcedures(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getProcedureColumns(String a, String b, String c, String d) throws SQLException {
		try {
			ResultSet exc = this.inner.getProcedureColumns(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	public final ResultSet getTables(String a, String b, String c, String[] d) throws SQLException {
		try {
			ResultSet exc = this.inner.getTables(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	public final ResultSet getSchemas() throws SQLException {
		try {
			ResultSet exc = this.inner.getSchemas();
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getCatalogs() throws SQLException {
		try {
			ResultSet exc = this.inner.getCatalogs();
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getTableTypes() throws SQLException {
		try {
			ResultSet exc = this.inner.getTableTypes();
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getColumnPrivileges(String a, String b, String c, String d) throws SQLException {
		try {
			ResultSet exc = this.inner.getColumnPrivileges(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	public final ResultSet getTablePrivileges(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getTablePrivileges(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getBestRowIdentifier(String a, String b, String c, int d, boolean e) throws SQLException {
		try {
			ResultSet exc = this.inner.getBestRowIdentifier(a, b, c, d, e);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg6) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg6);
			} else {
				throw arg6;
			}
		} catch (Exception arg7) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg7);
			} else {
				throw SqlUtils.toSQLException(arg7);
			}
		}
	}

	public final ResultSet getVersionColumns(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getVersionColumns(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getPrimaryKeys(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getPrimaryKeys(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getImportedKeys(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getImportedKeys(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getExportedKeys(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getExportedKeys(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getCrossReference(String a, String b, String c, String d, String e, String f) throws SQLException {
		try {
			ResultSet exc = this.inner.getCrossReference(a, b, c, d, e, f);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg7) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg7);
			} else {
				throw arg7;
			}
		} catch (Exception arg8) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg8);
			} else {
				throw SqlUtils.toSQLException(arg8);
			}
		}
	}

	public final ResultSet getTypeInfo() throws SQLException {
		try {
			ResultSet exc = this.inner.getTypeInfo();
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getIndexInfo(String a, String b, String c, boolean d, boolean e) throws SQLException {
		try {
			ResultSet exc = this.inner.getIndexInfo(a, b, c, d, e);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg6) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg6);
			} else {
				throw arg6;
			}
		} catch (Exception arg7) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg7);
			} else {
				throw SqlUtils.toSQLException(arg7);
			}
		}
	}

	public final boolean supportsResultSetType(int a) throws SQLException {
		try {
			return this.inner.supportsResultSetType(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean supportsResultSetConcurrency(int a, int b) throws SQLException {
		try {
			return this.inner.supportsResultSetConcurrency(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg3);
			} else {
				throw arg3;
			}
		} catch (Exception arg4) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg4);
			} else {
				throw SqlUtils.toSQLException(arg4);
			}
		}
	}

	public final boolean ownUpdatesAreVisible(int a) throws SQLException {
		try {
			return this.inner.ownUpdatesAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean ownDeletesAreVisible(int a) throws SQLException {
		try {
			return this.inner.ownDeletesAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean ownInsertsAreVisible(int a) throws SQLException {
		try {
			return this.inner.ownInsertsAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean othersUpdatesAreVisible(int a) throws SQLException {
		try {
			return this.inner.othersUpdatesAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean othersDeletesAreVisible(int a) throws SQLException {
		try {
			return this.inner.othersDeletesAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean othersInsertsAreVisible(int a) throws SQLException {
		try {
			return this.inner.othersInsertsAreVisible(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean updatesAreDetected(int a) throws SQLException {
		try {
			return this.inner.updatesAreDetected(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean deletesAreDetected(int a) throws SQLException {
		try {
			return this.inner.deletesAreDetected(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean insertsAreDetected(int a) throws SQLException {
		try {
			return this.inner.insertsAreDetected(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final boolean supportsBatchUpdates() throws SQLException {
		try {
			return this.inner.supportsBatchUpdates();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getUDTs(String a, String b, String c, int[] d) throws SQLException {
		try {
			ResultSet exc = this.inner.getUDTs(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	public final boolean supportsSavepoints() throws SQLException {
		try {
			return this.inner.supportsSavepoints();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsNamedParameters() throws SQLException {
		try {
			return this.inner.supportsNamedParameters();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsMultipleOpenResults() throws SQLException {
		try {
			return this.inner.supportsMultipleOpenResults();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsGetGeneratedKeys() throws SQLException {
		try {
			return this.inner.supportsGetGeneratedKeys();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getSuperTypes(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getSuperTypes(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final ResultSet getSuperTables(String a, String b, String c) throws SQLException {
		try {
			ResultSet exc = this.inner.getSuperTables(a, b, c);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg4);
			} else {
				throw arg4;
			}
		} catch (Exception arg5) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg5);
			} else {
				throw SqlUtils.toSQLException(arg5);
			}
		}
	}

	public final boolean supportsResultSetHoldability(int a) throws SQLException {
		try {
			return this.inner.supportsResultSetHoldability(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg2);
			} else {
				throw arg2;
			}
		} catch (Exception arg3) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg3);
			} else {
				throw SqlUtils.toSQLException(arg3);
			}
		}
	}

	public final int getDatabaseMajorVersion() throws SQLException {
		try {
			return this.inner.getDatabaseMajorVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getDatabaseMinorVersion() throws SQLException {
		try {
			return this.inner.getDatabaseMinorVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getJDBCMajorVersion() throws SQLException {
		try {
			return this.inner.getJDBCMajorVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getJDBCMinorVersion() throws SQLException {
		try {
			return this.inner.getJDBCMinorVersion();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final int getSQLStateType() throws SQLException {
		try {
			return this.inner.getSQLStateType();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean locatorsUpdateCopy() throws SQLException {
		try {
			return this.inner.locatorsUpdateCopy();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean supportsStatementPooling() throws SQLException {
		try {
			return this.inner.supportsStatementPooling();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getURL() throws SQLException {
		try {
			return this.inner.getURL();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final boolean isReadOnly() throws SQLException {
		try {
			return this.inner.isReadOnly();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getAttributes(String a, String b, String c, String d) throws SQLException {
		try {
			ResultSet exc = this.inner.getAttributes(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	public final Connection getConnection() throws SQLException {
		try {
			return this.proxyCon;
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final String getUserName() throws SQLException {
		try {
			return this.inner.getUserName();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg1);
			} else {
				throw arg1;
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			} else {
				throw SqlUtils.toSQLException(arg2);
			}
		}
	}

	public final ResultSet getColumns(String a, String b, String c, String d) throws SQLException {
		try {
			ResultSet exc = this.inner.getColumns(a, b, c, d);
			return exc == null ? null : new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed DatabaseMetaData!!!", arg5);
			} else {
				throw arg5;
			}
		} catch (Exception arg6) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg6);
			} else {
				throw SqlUtils.toSQLException(arg6);
			}
		}
	}

	void attach(NewPooledConnection parentPooledConnection) {
		this.parentPooledConnection = parentPooledConnection;
		parentPooledConnection.addConnectionEventListener(this.cel);
	}

	private void detach() {
		this.parentPooledConnection.removeConnectionEventListener(this.cel);
		this.parentPooledConnection = null;
	}

	NewProxyDatabaseMetaData(DatabaseMetaData inner, NewPooledConnection parentPooledConnection) {
		this(inner);
		this.attach(parentPooledConnection);
	}

	boolean isDetached() {
		return this.parentPooledConnection == null;
	}

	NewProxyDatabaseMetaData(DatabaseMetaData inner, NewPooledConnection parentPooledConnection, NewProxyConnection proxyCon) {
		this(inner, parentPooledConnection);
		this.proxyCon = proxyCon;
	}

	public Object unwrap(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public RowIdLifetime getRowIdLifetime() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public ResultSet getClientInfoProperties() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean generatedKeyAlwaysReturned() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
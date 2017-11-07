package com.mchange.v2.c3p0.impl;

import com.mchange.v2.c3p0.impl.NewPooledConnection;
import com.mchange.v2.c3p0.impl.NewProxyConnection;
import com.mchange.v2.log.MLevel;
import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.sql.SqlUtils;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

public final class NewProxyResultSet implements ResultSet {
	class NewProxyResultSetConnectionEventListener implements ConnectionEventListener {
		private NewProxyResultSet newProxyResultSet;

		public NewProxyResultSetConnectionEventListener(NewProxyResultSet newProxyResultSet) {
			this.newProxyResultSet = newProxyResultSet;
		}

		public void connectionErrorOccurred(ConnectionEvent evt) {
		}

		public void connectionClosed(ConnectionEvent evt) {
			try {
				newProxyResultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected ResultSet inner;
	private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyResultSet");
	volatile NewPooledConnection parentPooledConnection;
	ConnectionEventListener cel;
	Object creator;
	Object creatorProxy;
	NewProxyConnection proxyConn;

	public NewProxyResultSet(ResultSet inner) {
		this.cel = new NewProxyResultSetConnectionEventListener(this);
		this.inner = inner;
	}

	public final ResultSetMetaData getMetaData() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getMetaData();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final Statement getStatement() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			if (this.creator instanceof Statement) {
				return (Statement) this.creatorProxy;
			} else if (this.creator instanceof DatabaseMetaData) {
				return null;
			} else {
				throw new InternalError("Must be Statement or DatabaseMetaData -- Bad Creator: " + this.creator);
			}
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final SQLWarning getWarnings() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getWarnings();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void clearWarnings() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.clearWarnings();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void setFetchDirection(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.setFetchDirection(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getFetchDirection() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getFetchDirection();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void setFetchSize(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.setFetchSize(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getFetchSize() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getFetchSize();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean wasNull() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.wasNull();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final Blob getBlob(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBlob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Blob getBlob(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBlob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Clob getClob(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getClob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Clob getClob(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getClob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getAsciiStream(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getAsciiStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getAsciiStream(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getAsciiStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getUnicodeStream(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getUnicodeStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getUnicodeStream(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getUnicodeStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getBinaryStream(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBinaryStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final InputStream getBinaryStream(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBinaryStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final String getCursorName() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getCursorName();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final int findColumn(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.findColumn(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Reader getCharacterStream(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getCharacterStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Reader getCharacterStream(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getCharacterStream(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean isBeforeFirst() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.isBeforeFirst();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean isAfterLast() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.isAfterLast();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean isLast() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.isLast();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void beforeFirst() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.beforeFirst();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void afterLast() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.afterLast();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final int getRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean absolute(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.absolute(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean relative(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.relative(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getConcurrency() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getConcurrency();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean rowUpdated() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.rowUpdated();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean rowInserted() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.rowInserted();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean rowDeleted() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.rowDeleted();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void updateNull(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateNull(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final void updateNull(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateNull(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final void updateBoolean(int a, boolean b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBoolean(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBoolean(String a, boolean b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBoolean(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateByte(int a, byte b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateByte(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateByte(String a, byte b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateByte(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateShort(int a, short b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateShort(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateShort(String a, short b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateShort(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateInt(String a, int b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateInt(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateInt(int a, int b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateInt(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateLong(int a, long b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateLong(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateLong(String a, long b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateLong(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateFloat(int a, float b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateFloat(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateFloat(String a, float b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateFloat(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateDouble(String a, double b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateDouble(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateDouble(int a, double b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateDouble(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateBigDecimal(String a, BigDecimal b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBigDecimal(int a, BigDecimal b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateString(String a, String b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateString(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateString(int a, String b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateString(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBytes(String a, byte[] b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBytes(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBytes(int a, byte[] b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBytes(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateDate(int a, Date b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateDate(String a, Date b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateTimestamp(String a, Timestamp b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateTimestamp(int a, Timestamp b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateAsciiStream(String a, InputStream b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateAsciiStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateAsciiStream(int a, InputStream b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateAsciiStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateBinaryStream(String a, InputStream b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBinaryStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateBinaryStream(int a, InputStream b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBinaryStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateCharacterStream(String a, Reader b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateCharacterStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateCharacterStream(int a, Reader b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateCharacterStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateObject(int a, Object b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateObject(int a, Object b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateObject(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void updateObject(String a, Object b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateObject(String a, Object b, int c) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateObject(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg4);
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

	public final void insertRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.insertRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void updateRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void deleteRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.deleteRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void refreshRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.refreshRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void cancelRowUpdates() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.cancelRowUpdates();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void moveToInsertRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.moveToInsertRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void moveToCurrentRow() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.moveToCurrentRow();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void updateRef(String a, Ref b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateRef(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateRef(int a, Ref b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateRef(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBlob(String a, Blob b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBlob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateBlob(int a, Blob b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateBlob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateClob(String a, Clob b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateClob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateClob(int a, Clob b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateClob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateArray(int a, Array b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateArray(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateArray(String a, Array b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateArray(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Object getObject(String a, Map b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Object getObject(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getObject(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Object getObject(int a, Map b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Object getObject(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getObject(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean getBoolean(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBoolean(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean getBoolean(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBoolean(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final byte getByte(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getByte(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final byte getByte(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getByte(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final short getShort(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getShort(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final short getShort(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getShort(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getInt(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getInt(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getInt(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getInt(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final long getLong(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getLong(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final long getLong(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getLong(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final float getFloat(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getFloat(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final float getFloat(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getFloat(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final double getDouble(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDouble(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final double getDouble(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDouble(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final byte[] getBytes(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBytes(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final byte[] getBytes(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBytes(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Array getArray(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getArray(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Array getArray(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getArray(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean next() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.next();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final URL getURL(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getURL(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final URL getURL(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getURL(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final int getType() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getType();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final boolean previous() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.previous();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final void close() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			if (!this.isDetached()) {
				if (this.creator instanceof Statement) {
					this.parentPooledConnection.markInactiveResultSetForStatement((Statement) this.creator, this.inner);
				} else if (this.creator instanceof DatabaseMetaData) {
					this.parentPooledConnection.markInactiveMetaDataResultSet(this.inner);
				} else {
					if (!(this.creator instanceof Connection)) {
						throw new InternalError("Must be Statement or DatabaseMetaData -- Bad Creator: " + this.creator);
					}

					this.parentPooledConnection.markInactiveRawConnectionResultSet(this.inner);
				}

				this.detach();
				this.inner.close();
				this.inner = null;
			}
		} catch (NullPointerException arg1) {
			if (!this.isDetached()) {
				throw arg1;
			}

			if (logger.isLoggable(MLevel.FINE)) {
				logger.log(MLevel.FINE, this + ": close() called more than once.");
			}
		} catch (Exception arg2) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg2);
			}

			throw SqlUtils.toSQLException(arg2);
		}

	}

	public final Ref getRef(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getRef(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Ref getRef(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getRef(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean first() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.first();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final Time getTime(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTime(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Time getTime(String a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Time getTime(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTime(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Time getTime(int a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Date getDate(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDate(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Date getDate(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDate(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Date getDate(int a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Date getDate(String a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final String getString(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getString(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final String getString(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getString(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final boolean last() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.last();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final Timestamp getTimestamp(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTimestamp(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Timestamp getTimestamp(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTimestamp(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final Timestamp getTimestamp(int a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final Timestamp getTimestamp(String a, Calendar b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final boolean isFirst() throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.isFirst();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg1);
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

	public final BigDecimal getBigDecimal(int a, int b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final BigDecimal getBigDecimal(String a, int b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final BigDecimal getBigDecimal(int a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBigDecimal(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final BigDecimal getBigDecimal(String a) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			return this.inner.getBigDecimal(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg2);
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

	public final void updateTime(int a, Time b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	public final void updateTime(String a, Time b) throws SQLException {
		try {
			if (this.proxyConn != null) {
				this.proxyConn.maybeDirtyTransaction();
			}

			this.inner.updateTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed ResultSet!!!", arg3);
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

	void attach(NewPooledConnection parentPooledConnection) {
		this.parentPooledConnection = parentPooledConnection;
		parentPooledConnection.addConnectionEventListener(this.cel);
	}

	private void detach() {
		this.parentPooledConnection.removeConnectionEventListener(this.cel);
		this.parentPooledConnection = null;
	}

	NewProxyResultSet(ResultSet inner, NewPooledConnection parentPooledConnection) {
		this(inner);
		this.attach(parentPooledConnection);
	}

	boolean isDetached() {
		return this.parentPooledConnection == null;
	}

	NewProxyResultSet(ResultSet inner, NewPooledConnection parentPooledConnection, Object c, Object cProxy) {
		this(inner, parentPooledConnection);
		this.creator = c;
		this.creatorProxy = cProxy;
		if (this.creatorProxy instanceof NewProxyConnection) {
			this.proxyConn = (NewProxyConnection) cProxy;
		}

	}

	public Object unwrap(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public RowId getRowId(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public RowId getRowId(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateNString(int columnIndex, String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNString(String columnLabel, String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub

	}

	public NClob getNClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public NClob getNClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	public String getNString(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNString(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Object getObject(int columnIndex, Class type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(String columnLabel, Class type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
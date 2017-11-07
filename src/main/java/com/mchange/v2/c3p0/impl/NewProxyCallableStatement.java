package com.mchange.v2.c3p0.impl;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

import com.mchange.v2.c3p0.C3P0ProxyStatement;
import com.mchange.v2.log.MLevel;
import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.sql.SqlUtils;

public final class NewProxyCallableStatement implements CallableStatement, C3P0ProxyStatement {
	class NewProxyCallableStatementConnectionEventListener implements ConnectionEventListener {
		private NewProxyCallableStatement proxyCallableStatement;

		public NewProxyCallableStatementConnectionEventListener(NewProxyCallableStatement proxyCallableStatement) {
			this.proxyCallableStatement = proxyCallableStatement;
		}

		public void connectionErrorOccurred(ConnectionEvent evt) {
		}

		public void connectionClosed(ConnectionEvent evt) {
			try {
				proxyCallableStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected CallableStatement inner;
	private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyCallableStatement");
	volatile NewPooledConnection parentPooledConnection;
	ConnectionEventListener cel;
	boolean is_cached;
	NewProxyConnection creatorProxy;

	public NewProxyCallableStatement(CallableStatement inner) {
		this.cel = new NewProxyCallableStatementConnectionEventListener(this);
		this.inner = inner;
	}

	public final void setNull(String a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setNull(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setNull(String a, int b, String c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setNull(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setBigDecimal(String a, BigDecimal b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setBytes(String a, byte[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBytes(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setAsciiStream(String a, InputStream b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setAsciiStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setBinaryStream(String a, InputStream b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBinaryStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setObject(String a, Object b, int c, int d) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b, c, d);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg5);
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

	public final void setObject(String a, Object b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setObject(String a, Object b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setCharacterStream(String a, Reader b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setCharacterStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void registerOutParameter(int a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void registerOutParameter(String a, int b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void registerOutParameter(String a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void registerOutParameter(int a, int b, String c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void registerOutParameter(int a, int b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void registerOutParameter(String a, int b, String c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.registerOutParameter(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final boolean wasNull() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.wasNull();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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
			this.maybeDirtyTransaction();
			return this.inner.getBlob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getBlob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getClob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getClob(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final Object getObject(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getObject(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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
			this.maybeDirtyTransaction();
			return this.inner.getObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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
			this.maybeDirtyTransaction();
			return this.inner.getObject(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getBoolean(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getBoolean(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getByte(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getByte(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getShort(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getShort(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getInt(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getInt(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getLong(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getLong(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getFloat(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getFloat(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getDouble(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getDouble(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getBytes(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getBytes(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getArray(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getArray(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final URL getURL(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getURL(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getURL(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void setBoolean(String a, boolean b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBoolean(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setByte(String a, byte b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setByte(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setShort(String a, short b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setShort(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setInt(String a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setInt(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setLong(String a, long b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setLong(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setFloat(String a, float b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setFloat(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setDouble(String a, double b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDouble(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setTimestamp(String a, Timestamp b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setTimestamp(String a, Timestamp b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTimestamp(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final Ref getRef(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getRef(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getRef(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void setURL(String a, URL b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setURL(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setTime(String a, Time b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setTime(String a, Time b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTime(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final Time getTime(int a, Calendar b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final Time getTime(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTime(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final Time getTime(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTime(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final Date getDate(int a, Calendar b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final Date getDate(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getDate(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final Date getDate(String a, Calendar b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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
			this.maybeDirtyTransaction();
			return this.inner.getDate(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getString(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final String getString(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getString(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final Timestamp getTimestamp(String a, Calendar b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final Timestamp getTimestamp(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTimestamp(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final Timestamp getTimestamp(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getTimestamp(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void setDate(String a, Date b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDate(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setDate(String a, Date b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setString(String a, String b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setString(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final BigDecimal getBigDecimal(int a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final BigDecimal getBigDecimal(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getBigDecimal(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final BigDecimal getBigDecimal(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getBigDecimal(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final ResultSetMetaData getMetaData() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getMetaData();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final ResultSet executeQuery() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			ResultSet exc = this.inner.executeQuery();
			if (exc == null) {
				return null;
			} else {
				this.parentPooledConnection.markActiveResultSetForStatement(this.inner, exc);
				return new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
			}
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int executeUpdate() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeUpdate();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void addBatch() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.addBatch();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setNull(int a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setNull(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setNull(int a, int b, String c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setNull(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setBigDecimal(int a, BigDecimal b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBigDecimal(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setBytes(int a, byte[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBytes(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setAsciiStream(int a, InputStream b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setAsciiStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setUnicodeStream(int a, InputStream b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setUnicodeStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setBinaryStream(int a, InputStream b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBinaryStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void clearParameters() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.clearParameters();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setObject(int a, Object b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setObject(int a, Object b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setObject(int a, Object b, int c, int d) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setObject(a, b, c, d);
		} catch (NullPointerException arg5) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg5);
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

	public final void setCharacterStream(int a, Reader b, int c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setCharacterStream(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setRef(int a, Ref b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setRef(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setBlob(int a, Blob b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBlob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setClob(int a, Clob b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setClob(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setArray(int a, Array b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setArray(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final ParameterMetaData getParameterMetaData() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getParameterMetaData();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setBoolean(int a, boolean b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setBoolean(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setByte(int a, byte b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setByte(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setShort(int a, short b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setShort(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setInt(int a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setInt(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setLong(int a, long b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setLong(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setFloat(int a, float b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setFloat(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setDouble(int a, double b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDouble(a, b);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setTimestamp(int a, Timestamp b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTimestamp(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setTimestamp(int a, Timestamp b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTimestamp(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setURL(int a, URL b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setURL(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setTime(int a, Time b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTime(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setTime(int a, Time b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setTime(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setDate(int a, Date b, Calendar c) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDate(a, b, c);
		} catch (NullPointerException arg4) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg4);
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

	public final void setDate(int a, Date b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setDate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final void setString(int a, String b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setString(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final boolean execute() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.execute();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final ResultSet executeQuery(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			ResultSet exc = this.inner.executeQuery(a);
			if (exc == null) {
				return null;
			} else {
				this.parentPooledConnection.markActiveResultSetForStatement(this.inner, exc);
				return new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
			}
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final int executeUpdate(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeUpdate(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final int executeUpdate(String a, String[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeUpdate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final int executeUpdate(String a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeUpdate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final int executeUpdate(String a, int[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeUpdate(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final int getMaxFieldSize() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getMaxFieldSize();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setMaxFieldSize(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setMaxFieldSize(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final int getMaxRows() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getMaxRows();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setMaxRows(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setMaxRows(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void setEscapeProcessing(boolean a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setEscapeProcessing(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final int getQueryTimeout() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getQueryTimeout();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setQueryTimeout(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setQueryTimeout(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final SQLWarning getWarnings() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getWarnings();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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
			this.maybeDirtyTransaction();
			this.inner.clearWarnings();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void setCursorName(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setCursorName(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final ResultSet getResultSet() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			ResultSet exc = this.inner.getResultSet();
			if (exc == null) {
				return null;
			} else {
				this.parentPooledConnection.markActiveResultSetForStatement(this.inner, exc);
				return new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
			}
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int getUpdateCount() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getUpdateCount();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final boolean getMoreResults() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getMoreResults();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final boolean getMoreResults(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getMoreResults(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void setFetchDirection(int a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.setFetchDirection(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getFetchDirection();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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
			this.maybeDirtyTransaction();
			this.inner.setFetchSize(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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
			this.maybeDirtyTransaction();
			return this.inner.getFetchSize();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int getResultSetConcurrency() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getResultSetConcurrency();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int getResultSetType() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getResultSetType();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final void addBatch(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.addBatch(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	public final void clearBatch() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.clearBatch();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int[] executeBatch() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.executeBatch();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final ResultSet getGeneratedKeys() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			ResultSet exc = this.inner.getGeneratedKeys();
			if (exc == null) {
				return null;
			} else {
				this.parentPooledConnection.markActiveResultSetForStatement(this.inner, exc);
				return new NewProxyResultSet(exc, this.parentPooledConnection, this.inner, this);
			}
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final int getResultSetHoldability() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.getResultSetHoldability();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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
			this.maybeDirtyTransaction();
			if (!this.isDetached()) {
				if (this.is_cached) {
					this.parentPooledConnection.checkinStatement(this.inner);
				} else {
					this.parentPooledConnection.markInactiveUncachedStatement(this.inner);

					try {
						this.inner.close();
					} catch (Exception arg2) {
						if (logger.isLoggable(MLevel.WARNING)) {
							logger.log(MLevel.WARNING, "Exception on close of inner statement.", arg2);
						}

						SQLException sqle = SqlUtils.toSQLException(arg2);
						throw sqle;
					}
				}

				this.detach();
				this.inner = null;
				this.creatorProxy = null;
			}
		} catch (NullPointerException arg3) {
			if (!this.isDetached()) {
				throw arg3;
			}

			if (logger.isLoggable(MLevel.FINE)) {
				logger.log(MLevel.FINE, this + ": close() called more than once.");
			}
		} catch (Exception arg4) {
			if (!this.isDetached()) {
				throw this.parentPooledConnection.handleThrowable(arg4);
			}

			throw SqlUtils.toSQLException(arg4);
		}

	}

	public final void cancel() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			this.inner.cancel();
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final Connection getConnection() throws SQLException {
		try {
			this.maybeDirtyTransaction();
			if (!this.isDetached()) {
				return this.creatorProxy;
			} else {
				throw new SQLException("You cannot operate on a closed Statement!");
			}
		} catch (NullPointerException arg1) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg1);
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

	public final boolean execute(String a, int b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.execute(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final boolean execute(String a, int[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.execute(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final boolean execute(String a, String[] b) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.execute(a, b);
		} catch (NullPointerException arg3) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg3);
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

	public final boolean execute(String a) throws SQLException {
		try {
			this.maybeDirtyTransaction();
			return this.inner.execute(a);
		} catch (NullPointerException arg2) {
			if (this.isDetached()) {
				throw SqlUtils.toSQLException("You can\'t operate on a closed Statement!!!", arg2);
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

	void attach(NewPooledConnection parentPooledConnection) {
		this.parentPooledConnection = parentPooledConnection;
		parentPooledConnection.addConnectionEventListener(this.cel);
	}

	private void detach() {
		this.parentPooledConnection.removeConnectionEventListener(this.cel);
		this.parentPooledConnection = null;
	}

	NewProxyCallableStatement(CallableStatement inner, NewPooledConnection parentPooledConnection) {
		this(inner);
		this.attach(parentPooledConnection);
	}

	boolean isDetached() {
		return this.parentPooledConnection == null;
	}

	NewProxyCallableStatement(CallableStatement inner, NewPooledConnection parentPooledConnection, boolean cached, NewProxyConnection cProxy) {
		this(inner, parentPooledConnection);
		this.is_cached = cached;
		this.creatorProxy = cProxy;
	}

	public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
		this.maybeDirtyTransaction();
		if (target == C3P0ProxyStatement.RAW_STATEMENT) {
			target = this.inner;
		}

		int out = 0;

		for (int innerResultSet = args.length; out < innerResultSet; ++out) {
			if (args[out] == C3P0ProxyStatement.RAW_STATEMENT) {
				args[out] = this.inner;
			}
		}

		Object arg6 = m.invoke(target, args);
		if (arg6 instanceof ResultSet) {
			ResultSet arg5 = (ResultSet) arg6;
			this.parentPooledConnection.markActiveResultSetForStatement(this.inner, arg5);
			arg6 = new NewProxyResultSet(arg5, this.parentPooledConnection, this.inner, this);
		}

		return arg6;
	}

	void maybeDirtyTransaction() {
		this.creatorProxy.maybeDirtyTransaction();
	}

	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNString(int parameterIndex, String value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public void setPoolable(boolean poolable) throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean isPoolable() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public void closeOnCompletion() throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean isCloseOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Object unwrap(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public RowId getRowId(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public RowId getRowId(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRowId(String parameterName, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNString(String parameterName, String value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(String parameterName, NClob value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setClob(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public NClob getNClob(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public NClob getNClob(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	public SQLXML getSQLXML(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLXML getSQLXML(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNString(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNString(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getNCharacterStream(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getNCharacterStream(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getCharacterStream(int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Reader getCharacterStream(String parameterName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBlob(String parameterName, Blob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setClob(String parameterName, Clob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setAsciiStream(String parameterName, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBinaryStream(String parameterName, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNCharacterStream(String parameterName, Reader value) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setClob(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setBlob(String parameterName, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setNClob(String parameterName, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Object getObject(int parameterIndex, Class type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(String parameterName, Class type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
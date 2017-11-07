package com.mchange.v2.c3p0.impl;

import com.mchange.v2.c3p0.C3P0ProxyStatement;
import com.mchange.v2.c3p0.impl.NewPooledConnection;
import com.mchange.v2.c3p0.impl.NewProxyConnection;
import com.mchange.v2.c3p0.impl.NewProxyResultSet;
import com.mchange.v2.log.MLevel;
import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.sql.SqlUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

public final class NewProxyStatement implements Statement, C3P0ProxyStatement {
	class NewProxyStatementConnectionEventListener implements ConnectionEventListener {
		private NewProxyStatement newProxyStatement;

		public NewProxyStatementConnectionEventListener(NewProxyStatement newProxyStatement) {
			this.newProxyStatement = newProxyStatement;
		}

		public void connectionErrorOccurred(ConnectionEvent evt) {
		}

		public void connectionClosed(ConnectionEvent evt) {
			try {
				newProxyStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected Statement inner;
	private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyStatement");
	volatile NewPooledConnection parentPooledConnection;
	ConnectionEventListener cel;
	boolean is_cached;
	NewProxyConnection creatorProxy;

	public NewProxyStatement(Statement inner) {
		this.cel = new NewProxyStatementConnectionEventListener(this);
		this.inner = inner;
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

	NewProxyStatement(Statement inner, NewPooledConnection parentPooledConnection) {
		this(inner);
		this.attach(parentPooledConnection);
	}

	boolean isDetached() {
		return this.parentPooledConnection == null;
	}

	NewProxyStatement(Statement inner, NewPooledConnection parentPooledConnection, boolean cached, NewProxyConnection cProxy) {
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

	public Object unwrap(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
}

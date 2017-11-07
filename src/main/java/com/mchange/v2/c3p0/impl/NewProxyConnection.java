package com.mchange.v2.c3p0.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

import com.mchange.v2.c3p0.C3P0ProxyConnection;
import com.mchange.v2.log.MLevel;
import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import com.mchange.v2.sql.SqlUtils;
import com.mchange.v2.util.ResourceClosedException;

public final class NewProxyConnection implements Connection, C3P0ProxyConnection {
	class NewProxyConnectionEventListener implements ConnectionEventListener {
		private NewProxyConnection proxyConnection ;
		public NewProxyConnectionEventListener(NewProxyConnection proxyConnection) {
			this.proxyConnection= proxyConnection;
		}

		public void connectionErrorOccurred(ConnectionEvent evt) {
		}

		public void connectionClosed(ConnectionEvent evt) {
			try {
				proxyConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
   protected Connection inner;
   boolean txn_known_resolved;
   DatabaseMetaData metaData;
   private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyConnection");
   volatile NewPooledConnection parentPooledConnection;
   ConnectionEventListener cel;

   public NewProxyConnection(Connection inner) {
      this.txn_known_resolved = true;
      this.metaData = null;
      this.cel = new NewProxyConnectionEventListener(this);
      this.inner = inner;
   }

   public synchronized Statement createStatement(int a, int b, int c) throws SQLException {
      try {
         this.txn_known_resolved = false;
         Statement exc = this.inner.createStatement(a, b, c);
         this.parentPooledConnection.markActiveUncachedStatement(exc);
         return new NewProxyStatement(exc, this.parentPooledConnection, false, this);
      } catch (NullPointerException arg4) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg4);
         } else {
            throw arg4;
         }
      } catch (Exception arg5) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg5);
         } else {
            throw SqlUtils.toSQLException(arg5);
         }
      }
   }

   public synchronized Statement createStatement(int a, int b) throws SQLException {
      try {
         this.txn_known_resolved = false;
         Statement exc = this.inner.createStatement(a, b);
         this.parentPooledConnection.markActiveUncachedStatement(exc);
         return new NewProxyStatement(exc, this.parentPooledConnection, false, this);
      } catch (NullPointerException arg3) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg3);
         } else {
            throw arg3;
         }
      } catch (Exception arg4) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg4);
         } else {
            throw SqlUtils.toSQLException(arg4);
         }
      }
   }

   public synchronized Statement createStatement() throws SQLException {
      try {
         this.txn_known_resolved = false;
         Statement exc = this.inner.createStatement();
         this.parentPooledConnection.markActiveUncachedStatement(exc);
         return new NewProxyStatement(exc, this.parentPooledConnection, false, this);
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a, String[] b) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, String[].class};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a, b};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg6) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg6);
               }

               exc = this.inner.prepareStatement(a, b);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a, b);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg7) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg7);
         } else {
            throw arg7;
         }
      } catch (Exception arg8) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg8);
         } else {
            throw SqlUtils.toSQLException(arg8);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg5) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg5);
               }

               exc = this.inner.prepareStatement(a);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg6) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg6);
         } else {
            throw arg6;
         }
      } catch (Exception arg7) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg7);
         } else {
            throw SqlUtils.toSQLException(arg7);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a, int b, int c) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, Integer.TYPE, Integer.TYPE};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a, new Integer(b), new Integer(c)};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg7) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg7);
               }

               exc = this.inner.prepareStatement(a, b, c);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a, b, c);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg8) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg8);
         } else {
            throw arg8;
         }
      } catch (Exception arg9) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg9);
         } else {
            throw SqlUtils.toSQLException(arg9);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a, int b, int c, int d) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a, new Integer(b), new Integer(c), new Integer(d)};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg8) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg8);
               }

               exc = this.inner.prepareStatement(a, b, c, d);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a, b, c, d);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg9) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg9);
         } else {
            throw arg9;
         }
      } catch (Exception arg10) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg10);
         } else {
            throw SqlUtils.toSQLException(arg10);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a, int b) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, Integer.TYPE};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a, new Integer(b)};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg6) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg6);
               }

               exc = this.inner.prepareStatement(a, b);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a, b);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg7) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg7);
         } else {
            throw arg7;
         }
      } catch (Exception arg8) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg8);
         } else {
            throw SqlUtils.toSQLException(arg8);
         }
      }
   }

   public synchronized PreparedStatement prepareStatement(String a, int[] b) throws SQLException {
      try {
         this.txn_known_resolved = false;
         PreparedStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, int[].class};
               Method method = Connection.class.getMethod("prepareStatement", e);
               Object[] args = new Object[]{a, b};
               exc = (PreparedStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg6) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a Statement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg6);
               }

               exc = this.inner.prepareStatement(a, b);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareStatement(a, b);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyPreparedStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg7) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg7);
         } else {
            throw arg7;
         }
      } catch (Exception arg8) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg8);
         } else {
            throw SqlUtils.toSQLException(arg8);
         }
      }
   }

   public synchronized CallableStatement prepareCall(String a, int b, int c, int d) throws SQLException {
      try {
         this.txn_known_resolved = false;
         CallableStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
               Method method = Connection.class.getMethod("prepareCall", e);
               Object[] args = new Object[]{a, new Integer(b), new Integer(c), new Integer(d)};
               exc = (CallableStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg8) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a CallableStatement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg8);
               }

               exc = this.inner.prepareCall(a, b, c, d);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareCall(a, b, c, d);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg9) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg9);
         } else {
            throw arg9;
         }
      } catch (Exception arg10) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg10);
         } else {
            throw SqlUtils.toSQLException(arg10);
         }
      }
   }

   public synchronized CallableStatement prepareCall(String a, int b, int c) throws SQLException {
      try {
         this.txn_known_resolved = false;
         CallableStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class, Integer.TYPE, Integer.TYPE};
               Method method = Connection.class.getMethod("prepareCall", e);
               Object[] args = new Object[]{a, new Integer(b), new Integer(c)};
               exc = (CallableStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg7) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a CallableStatement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg7);
               }

               exc = this.inner.prepareCall(a, b, c);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareCall(a, b, c);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg8) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg8);
         } else {
            throw arg8;
         }
      } catch (Exception arg9) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg9);
         } else {
            throw SqlUtils.toSQLException(arg9);
         }
      }
   }

   public synchronized CallableStatement prepareCall(String a) throws SQLException {
      try {
         this.txn_known_resolved = false;
         CallableStatement exc;
         if(this.parentPooledConnection.isStatementCaching()) {
            try {
               Class[] e = new Class[]{String.class};
               Method method = Connection.class.getMethod("prepareCall", e);
               Object[] args = new Object[]{a};
               exc = (CallableStatement)this.parentPooledConnection.checkoutStatement(method, args);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, true, this);
            } catch (ResourceClosedException arg5) {
               if(logger.isLoggable(MLevel.FINE)) {
                  logger.log(MLevel.FINE, "A Connection tried to prepare a CallableStatement via a Statement cache that is already closed. This can happen -- rarely -- if a DataSource is closed or reset() while Connections are checked-out and in use.", arg5);
               }

               exc = this.inner.prepareCall(a);
               this.parentPooledConnection.markActiveUncachedStatement(exc);
               return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
            }
         } else {
            exc = this.inner.prepareCall(a);
            this.parentPooledConnection.markActiveUncachedStatement(exc);
            return new NewProxyCallableStatement(exc, this.parentPooledConnection, false, this);
         }
      } catch (NullPointerException arg6) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg6);
         } else {
            throw arg6;
         }
      } catch (Exception arg7) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg7);
         } else {
            throw SqlUtils.toSQLException(arg7);
         }
      }
   }

   public synchronized DatabaseMetaData getMetaData() throws SQLException {
      try {
         this.txn_known_resolved = false;
         if(this.metaData == null) {
            DatabaseMetaData exc = this.inner.getMetaData();
            this.metaData = new NewProxyDatabaseMetaData(exc, this.parentPooledConnection, this);
         }

         return this.metaData;
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized void setTransactionIsolation(int a) throws SQLException {
      try {
         this.inner.setTransactionIsolation(a);
         this.parentPooledConnection.markNewTxnIsolation(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void setCatalog(String a) throws SQLException {
      try {
         this.inner.setCatalog(a);
         this.parentPooledConnection.markNewCatalog(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void setHoldability(int a) throws SQLException {
      try {
         this.inner.setHoldability(a);
         this.parentPooledConnection.markNewHoldability(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void setTypeMap(Map a) throws SQLException {
      try {
         this.inner.setTypeMap(a);
         this.parentPooledConnection.markNewTypeMap(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void commit() throws SQLException {
      try {
         this.txn_known_resolved = true;
         this.inner.commit();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized void rollback(Savepoint a) throws SQLException {
      try {
         this.txn_known_resolved = true;
         this.inner.rollback(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void rollback() throws SQLException {
      try {
         this.txn_known_resolved = true;
         this.inner.rollback();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized void setAutoCommit(boolean a) throws SQLException {
      try {
         this.txn_known_resolved = true;
         this.inner.setAutoCommit(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized SQLWarning getWarnings() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getWarnings();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized void clearWarnings() throws SQLException {
      try {
         this.txn_known_resolved = false;
         this.inner.clearWarnings();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized String nativeSQL(String a) throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.nativeSQL(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized boolean getAutoCommit() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getAutoCommit();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized String getCatalog() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getCatalog();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized int getTransactionIsolation() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getTransactionIsolation();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized Map getTypeMap() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getTypeMap();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized int getHoldability() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.getHoldability();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized Savepoint setSavepoint() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.setSavepoint();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized Savepoint setSavepoint(String a) throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.setSavepoint(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void releaseSavepoint(Savepoint a) throws SQLException {
      try {
         this.txn_known_resolved = false;
         this.inner.releaseSavepoint(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized void setReadOnly(boolean a) throws SQLException {
      try {
         this.inner.setReadOnly(a);
         this.parentPooledConnection.markNewReadOnly(a);
      } catch (NullPointerException arg2) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg2);
         } else {
            throw arg2;
         }
      } catch (Exception arg3) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg3);
         } else {
            throw SqlUtils.toSQLException(arg3);
         }
      }
   }

   public synchronized boolean isReadOnly() throws SQLException {
      try {
         this.txn_known_resolved = false;
         return this.inner.isReadOnly();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public synchronized void close() throws SQLException {
      try {
         if(!this.isDetached()) {
            NewPooledConnection exc = this.parentPooledConnection;
            this.detach();
            exc.markClosedProxyConnection(this, this.txn_known_resolved);
            this.inner = null;
         } else if(logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, this + ": close() called more than once.");
         }
      } catch (NullPointerException arg1) {
         if(!this.isDetached()) {
            throw arg1;
         }

         if(logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, this + ": close() called more than once.");
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         }

         throw SqlUtils.toSQLException(arg2);
      }

   }

   public synchronized boolean isClosed() throws SQLException {
      try {
         return this.isDetached();
      } catch (NullPointerException arg1) {
         if(this.isDetached()) {
            throw SqlUtils.toSQLException("You can\'t operate on a closed Connection!!!", arg1);
         } else {
            throw arg1;
         }
      } catch (Exception arg2) {
         if(!this.isDetached()) {
            throw this.parentPooledConnection.handleThrowable(arg2);
         } else {
            throw SqlUtils.toSQLException(arg2);
         }
      }
   }

   public Object rawConnectionOperation(Method m, Object target, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
      this.maybeDirtyTransaction();
      if(this.inner == null) {
         throw new SQLException("You cannot operate on a closed Connection!");
      } else {
         if(target == C3P0ProxyConnection.RAW_CONNECTION) {
            target = this.inner;
         }

         int out = 0;

         for(int innerRs = args.length; out < innerRs; ++out) {
            if(args[out] == C3P0ProxyConnection.RAW_CONNECTION) {
               args[out] = this.inner;
            }
         }

         Object arg5 = m.invoke(target, args);
         if(arg5 instanceof CallableStatement) {
            CallableStatement arg6 = (CallableStatement)arg5;
            this.parentPooledConnection.markActiveUncachedStatement(arg6);
            arg5 = new NewProxyCallableStatement(arg6, this.parentPooledConnection, false, this);
         } else if(arg5 instanceof PreparedStatement) {
            PreparedStatement arg8 = (PreparedStatement)arg5;
            this.parentPooledConnection.markActiveUncachedStatement(arg8);
            arg5 = new NewProxyPreparedStatement(arg8, this.parentPooledConnection, false, this);
         } else if(arg5 instanceof Statement) {
            Statement arg7 = (Statement)arg5;
            this.parentPooledConnection.markActiveUncachedStatement(arg7);
            arg5 = new NewProxyStatement(arg7, this.parentPooledConnection, false, this);
         } else if(arg5 instanceof ResultSet) {
            ResultSet arg9 = (ResultSet)arg5;
            this.parentPooledConnection.markActiveRawConnectionResultSet(arg9);
            arg5 = new NewProxyResultSet(arg9, this.parentPooledConnection, this.inner, this);
         } else if(arg5 instanceof DatabaseMetaData) {
            arg5 = new NewProxyDatabaseMetaData((DatabaseMetaData)arg5, this.parentPooledConnection);
         }

         return arg5;
      }
   }

   synchronized void maybeDirtyTransaction() {
      this.txn_known_resolved = false;
   }

   void attach(NewPooledConnection parentPooledConnection) {
      this.parentPooledConnection = parentPooledConnection;
      parentPooledConnection.addConnectionEventListener(this.cel);
   }

   private void detach() {
      this.parentPooledConnection.removeConnectionEventListener(this.cel);
      this.parentPooledConnection = null;
   }

   NewProxyConnection(Connection inner, NewPooledConnection parentPooledConnection) {
      this(inner);
      this.attach(parentPooledConnection);
   }

   boolean isDetached() {
      return this.parentPooledConnection == null;
   }

public Object unwrap(Class iface) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public boolean isWrapperFor(Class iface) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}

public Clob createClob() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public Blob createBlob() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public NClob createNClob() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public SQLXML createSQLXML() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public boolean isValid(int timeout) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}

public void setClientInfo(String name, String value) throws SQLClientInfoException {
	// TODO Auto-generated method stub
	
}

public void setClientInfo(Properties properties) throws SQLClientInfoException {
	// TODO Auto-generated method stub
	
}

public String getClientInfo(String name) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public Properties getClientInfo() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public void setSchema(String schema) throws SQLException {
	// TODO Auto-generated method stub
	
}

public String getSchema() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

public void abort(Executor executor) throws SQLException {
	// TODO Auto-generated method stub
	
}

public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
	// TODO Auto-generated method stub
	
}

public int getNetworkTimeout() throws SQLException {
	// TODO Auto-generated method stub
	return 0;
}
}
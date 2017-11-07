package com.mchange.v2.c3p0.impl;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.cfg.C3P0Config;
import com.mchange.v2.c3p0.impl.C3P0Defaults;
import com.mchange.v2.c3p0.impl.C3P0ImplUtils;
import com.mchange.v2.c3p0.impl.IdentityTokenResolvable;
import com.mchange.v2.naming.JavaBeanReferenceMaker;
import com.mchange.v2.naming.ReferenceIndirector;
import com.mchange.v2.ser.IndirectlySerialized;
import com.mchange.v2.ser.SerializableUtils;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.ConnectionPoolDataSource;

public class PoolBackedDataSourceBase extends IdentityTokenResolvable
		implements
			Referenceable,
			Serializable {
	protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	protected VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	private ConnectionPoolDataSource connectionPoolDataSource;
	private String dataSourceName = null;
	private String factoryClassLocation = C3P0Config
			.initializeStringPropertyVar("factoryClassLocation",
					C3P0Defaults.factoryClassLocation());
	private String identityToken;
	private int numHelperThreads = C3P0Config.initializeIntPropertyVar(
			"numHelperThreads", C3P0Defaults.numHelperThreads());
	private static final long serialVersionUID = 1L;
	private static final short VERSION = 1;
	static final JavaBeanReferenceMaker referenceMaker = new JavaBeanReferenceMaker();

	protected PropertyChangeSupport getPropertyChangeSupport() {
		return this.pcs;
	}

	protected VetoableChangeSupport getVetoableChangeSupport() {
		return this.vcs;
	}

	public synchronized ConnectionPoolDataSource getConnectionPoolDataSource() {
		return this.connectionPoolDataSource;
	}

	public synchronized void setConnectionPoolDataSource(
			ConnectionPoolDataSource connectionPoolDataSource)
			throws PropertyVetoException {
		ConnectionPoolDataSource oldVal = this.connectionPoolDataSource;
		if (!this.eqOrBothNull(oldVal, connectionPoolDataSource)) {
			this.vcs.fireVetoableChange("connectionPoolDataSource", oldVal,
					connectionPoolDataSource);
		}

		this.connectionPoolDataSource = connectionPoolDataSource;
		if (!this.eqOrBothNull(oldVal, connectionPoolDataSource)) {
			this.pcs.firePropertyChange("connectionPoolDataSource", oldVal,
					connectionPoolDataSource);
		}

	}

	public synchronized String getDataSourceName() {
		return this.dataSourceName;
	}

	public synchronized void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public synchronized String getFactoryClassLocation() {
		return this.factoryClassLocation;
	}

	public synchronized void setFactoryClassLocation(String factoryClassLocation) {
		this.factoryClassLocation = factoryClassLocation;
	}

	public synchronized String getIdentityToken() {
		return this.identityToken;
	}

	public synchronized void setIdentityToken(String identityToken) {
		String oldVal = this.identityToken;
		this.identityToken = identityToken;
		if (!this.eqOrBothNull(oldVal, identityToken)) {
			this.pcs.firePropertyChange("identityToken", oldVal, identityToken);
		}

	}

	public synchronized int getNumHelperThreads() {
		return this.numHelperThreads;
	}

	public synchronized void setNumHelperThreads(int numHelperThreads) {
		int oldVal = this.numHelperThreads;
		this.numHelperThreads = numHelperThreads;
		if (oldVal != numHelperThreads) {
			this.pcs.firePropertyChange("numHelperThreads", oldVal,
					numHelperThreads);
		}

	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}

	public void addPropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(propName, pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.removePropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		this.pcs.removePropertyChangeListener(propName, pcl);
	}

	public void addVetoableChangeListener(VetoableChangeListener vcl) {
		this.vcs.addVetoableChangeListener(vcl);
	}

	public void removeVetoableChangeListener(VetoableChangeListener vcl) {
		this.vcs.removeVetoableChangeListener(vcl);
	}

	private boolean eqOrBothNull(Object a, Object b) {
		return a == b || a != null && a.equals(b);
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeShort(1);

		try {
			SerializableUtils.toByteArray(this.connectionPoolDataSource);
			oos.writeObject(this.connectionPoolDataSource);
		} catch (NotSerializableException arg5) {
			try {
				ReferenceIndirector indirectionOtherException = new ReferenceIndirector();
				oos.writeObject(indirectionOtherException
						.indirectForm(this.connectionPoolDataSource));
			} catch (IOException arg3) {
				throw arg3;
			} catch (Exception arg4) {
				throw new IOException(
						"Problem indirectly serializing connectionPoolDataSource: "
								+ arg4.toString());
			}
		}

		oos.writeObject(this.dataSourceName);
		oos.writeObject(this.factoryClassLocation);
		oos.writeObject(this.identityToken);
		oos.writeInt(this.numHelperThreads);
	}

	private void readObject(ObjectInputStream ois) throws IOException,
			ClassNotFoundException {
		short version = ois.readShort();
		switch (version) {
			case 1 :
				Object o = ois.readObject();
				if (o instanceof IndirectlySerialized) {
					o = ((IndirectlySerialized) o).getObject();
				}

				this.connectionPoolDataSource = (ConnectionPoolDataSource) o;
				this.dataSourceName = (String) ois.readObject();
				this.factoryClassLocation = (String) ois.readObject();
				this.identityToken = (String) ois.readObject();
				this.numHelperThreads = ois.readInt();
				this.pcs = new PropertyChangeSupport(this);
				this.vcs = new VetoableChangeSupport(this);
				return;
			default :
				throw new IOException("Unsupported Serialized Version: "
						+ version);
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append(" [ ");
		sb.append("connectionPoolDataSource -> "
				+ this.connectionPoolDataSource);
		sb.append(", ");
		sb.append("dataSourceName -> " + this.dataSourceName);
		sb.append(", ");
		sb.append("factoryClassLocation -> " + this.factoryClassLocation);
		sb.append(", ");
		sb.append("identityToken -> " + this.identityToken);
		sb.append(", ");
		sb.append("numHelperThreads -> " + this.numHelperThreads);
		String extraToStringInfo = this.extraToStringInfo();
		if (extraToStringInfo != null) {
			sb.append(extraToStringInfo);
		}

		sb.append(" ]");
		return sb.toString();
	}

	protected String extraToStringInfo() {
		return null;
	}

	public Reference getReference() throws NamingException {
		return referenceMaker.createReference(this);
	}

	private PoolBackedDataSourceBase() {
	}

	public PoolBackedDataSourceBase(boolean autoregister) {
		if (autoregister) {
			this.identityToken = C3P0ImplUtils.allocateIdentityToken(this);
			C3P0Registry.reregister(this);
		}

	}

	static {
		referenceMaker
				.setFactoryClassName("com.mchange.v2.c3p0.impl.C3P0JavaBeanObjectFactory");
		referenceMaker.addReferenceProperty("connectionPoolDataSource");
		referenceMaker.addReferenceProperty("dataSourceName");
		referenceMaker.addReferenceProperty("factoryClassLocation");
		referenceMaker.addReferenceProperty("identityToken");
		referenceMaker.addReferenceProperty("numHelperThreads");
	}
}
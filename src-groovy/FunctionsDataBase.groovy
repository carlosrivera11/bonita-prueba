import javax.sql.DataSource

import javax.naming.Context
import javax.naming.InitialContext
import java.sql.Connection
import groovy.sql.Sql

static getMap(jndi, query){
	def sql = null;
	def resultado = [:]
	try{
		
		Connection conn = null
		conn = getConnection(jndi)
		sql = new Sql(conn)
		sql.eachRow(query) {
			row->
			
			resultado.put( row[0], row[1] )
		}
			
	}catch(Exception ex){
		throw ex
	}finally{
		sql.close()
	}
	return resultado
}

static getList(jndi, query){
	def sql = null
	def resultado = []
	try{
		
		Connection conn = null
		conn = getConnection(jndi)
		sql = new Sql(conn)
		
		sql.eachRow(query) {
			row->
			
			def subList = []
			
			row.toRowResult().values().each{
				subList.add(it)
			}
			
			resultado.add(subList)
		}
			
	}catch(Exception ex){
		throw ex
	}finally{
		sql.close()
	}
	return resultado
}

static getSingleData(jndi, query){
	def sql = null
	try{
		
		Connection conn = null
		conn = getConnection(jndi)
		sql = new Sql(conn)
		
		def salida = sql.firstRow(query)
		return salida[0]
			
	}catch(Exception ex){
		throw ex
	}finally{
		sql.close()
	}
	return ""
}


static getConnection(jndi){
	try{
		def context = new InitialContext()
		def ds = context.lookup(jndi)
		return ds.getConnection()
	}catch(Exception ex){
		throw ex
	}
}
package com.rest

import grails.transaction.Transactional

@Transactional
class CustomersService {

	def list() {
		log.info("Masuk Service")
		try {
			List result = new ArrayList()
			def coreList = Customers.executeQuery("from Customers")
			log.info (coreList.size())
			
			coreList.each {
				Map data = new HashMap()
				data.put("customername", it.customername)
				data.put("password", it.password)
				data.put("role", it.role)
				result.add(data)
			}
			return [code: 1, info: 'Success', data: result]
		} catch (e) {
			log.error(e.getMessage(), e)
			def errData = [code: 0, info: e.message]
			return
		}
	}
}

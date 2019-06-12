package com.rest

import grails.converters.JSON
import org.apache.commons.logging.LogFactory

class CustomersController {

	private static final log = LogFactory.getLog(this)
	static allowedMethods = [list: "GET"]
	
	def customersService

	def list(){
		try{
			log.info("Masuk Controller")
			render customersService.list() as JSON
			return
		}catch(e){
			log.error(e.getMessage(), e)
			def errData = [code:0, info:e.message]
			render errData as JSON
			return
		}
	}
}

package org.hakeem.unidata.services;

import org.hakeem.unidata.hr.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

   @Autowired
   PersonRepository personRepository;


}

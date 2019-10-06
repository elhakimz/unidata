package org.hakeem.unidata.base.services;


import org.hakeem.unidata.core.commons.BaseService;
import org.hakeem.unidata.model.entities.*;
import org.hakeem.unidata.model.repositories.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Business Party Services
 * @author  abiel
 */
@Service
public class PartyService  extends BaseService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OrganizationRepository orgRepository;

    @Autowired
    private PartyRoleRepository roleRepository;

    @Autowired
    private PartyRelationshipRepository relationshipRepository;

    /**
     * create person
     * @param firstName first name
     * @param lastName last name
     * @return person
     */
    @NotNull
    public Person createPerson(String firstName, String lastName){

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return personRepository.save(person);
    }

    /**
     * create organization
     * @param name name
     * @param taxIdNumber  tax id number
     * @return organization
     */
    @NotNull
    public Organization createOrganization(String name, String taxIdNumber){
        Organization organization= new Organization();
        organization.setTaxIdNumber(taxIdNumber);
        return  orgRepository.save(organization);
    }

    /**
     * register person as party
     * @param person person
     * @return  party
     */
    @NotNull
    public Party registerPerson(@NotNull Person person){
         Party party= new Party();
         party.setName( person.getFirstName()+" "+person.getLastName());
         party.setType(EPartyType.PERSON);
         party = partyRepository.save(party);
         person.setParty(party);
         personRepository.save(person);
         return party;
    }

    /**
     * register organization as party
     * @param organization organization
     */
    @NotNull
    public Party registerOrganization( @NotNull  Organization organization){
        Party party= new Party();
        party.setName( organization.getTaxIdNumber());
        party.setType(EPartyType.ORGANIZATION);
        party = partyRepository.save(party);
        organization.setParty(party);
        orgRepository.save(organization);
        return party;
    }

    /**
     * apply role
     * @param party  party
     * @param roleType  role type
     * @param name name
     * @param fromDate  from date
     * @param thruDate   thru date
     * @return  party role
     */
    @NotNull
    public PartyRole applyRole(@NotNull Party party, @NotNull PartyRoleType roleType,
                               String name,
                               LocalDate fromDate, LocalDate thruDate){
        PartyRole partyRole= new PartyRole();
        partyRole.setParty(party);
        partyRole.setRoleType(roleType);
        partyRole.setName(name != null ? name:roleType.getName());
        partyRole.setStartDate(fromDate);
        partyRole.setEndDate(thruDate);
        partyRole.setParty(party);
        return roleRepository.save(partyRole);
    }

    /**
     * register relationship
     * @param roleFrom role from
     * @param roleTo   role to
     * @return  party relationship
     */
    @NotNull
    public  PartyRelationship registerRelationship(PartyRole roleFrom, PartyRole roleTo, PartyRelationshipType relationshipType,
                                                   String description,
                                                   LocalDate fromDate, LocalDate thruDate){
         PartyRelationship relationship = new PartyRelationship();
         relationship.setInvolveFrom(roleFrom);
         relationship.setInvolveTo(roleTo);
         relationship.setRelationshipType(relationshipType);
         relationship.setDescription(description != null ? description : relationshipType.getDescription() );
         relationship.setFromDate(fromDate);
         relationship.setToDate(thruDate);
         return relationshipRepository.save(relationship);
    }

    /**
     * find party by its id
     * @param uuid id
     * @return  party
     */
    public Party findPartyById(UUID uuid){
        final Party[] party = new Party[1];
         partyRepository.findById(uuid).ifPresent( p -> party[0] = p);
         return party[0];
    }

    /**
     * find a person data by its party data
     * @param party party
     * @return person
     */
    public Person getPersonByParty(@NotNull  Party party){
        return personRepository.findByParty(party);
    }


    /**
     * find organization by party
     * @param party party
     * @return organization
     */
    public  Organization findOrganizationByParty(@NotNull Party party){
        return  orgRepository.findByParty(party);
    }


}

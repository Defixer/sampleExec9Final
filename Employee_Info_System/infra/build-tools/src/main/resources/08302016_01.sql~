alter table person_role
drop constraint fk68b7ef206be261b6,
drop constraint fk68b7ef20fc42c2ae;

alter table person_role
add constraint fk68b7ef206be261b6 FOREIGN KEY (persons_id) REFERENCES person(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
add constraint fk68b7ef20fc42c2ae FOREIGN KEY (roles_roleid) REFERENCES role(roleid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE;




alter table person_contact
drop constraint fk1b42c116763b5abf,
drop constraint fk1b42c11691615695;

alter table person_contact
add constraint fk1b42c116763b5abf FOREIGN KEY (person_id) REFERENCES person(id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
add constraint fk1b42c11691615695 FOREIGN KEY (contacts_contactid) REFERENCES contact(contactid) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;

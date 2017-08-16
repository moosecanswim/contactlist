package me.moosecanswim.contactlist.Repository;

import me.moosecanswim.contactlist.Model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long> {
}

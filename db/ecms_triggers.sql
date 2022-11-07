  
delimiter #
 create trigger ProductsTrigger after insert on products
    for each row
   begin
	insert into productslist (prid, prnm,qty,priceperunit,description) values (new.prid, new.prnm,new.qty,new.priceperunit,new.description);
    end#
    



delimiter #
 create trigger ProductImagesTrigger after insert on productimages
    for each row
   begin
   UPDATE productslist SET image=NEW.image,discount=0,name=new.name,type=new.type WHERE productslist.prid=NEW.prid;

    end#
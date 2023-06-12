
 --INSERT INTO Media (id,name,type,description,hour,minute,thumbnailWeb,thumbnailMobile,thumbnailTv,cdnPath,stream) 
--            values (1,'Journey to Mecca 1','Documentary','Journey to Mecca 1',1,20,'web.png','mobile.png','tv.png','','vod');

INSERT INTO Tag (id,name,description) values (1,'Drama','Drama');
INSERT INTO Tag (id,name,description) values (2,'Action','Action');
INSERT INTO Tag (id,name,description) values (3,'Comedy','Comedy');
INSERT INTO Tag (id,name,description) values (4,'Animation','Animation');
INSERT INTO Tag (id,name,description) values (5,'Adventure','Adventure');
INSERT INTO Tag (id,name,description) values (6,'Western','Western');

--INSERT INTO media_tag (media_id,tag_id) values (1,1);

--INSERT INTO Collection (id,name,type,description) values (1,'Journey to Mecca','Documentary','Journey to mecca');

--INSERT INTO Collection_Item (id,mediaCollection_id,media_id,episode) values (1,1,1,2);

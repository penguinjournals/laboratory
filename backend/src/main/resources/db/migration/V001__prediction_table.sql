create table prediction
(
	id serial not null,
	title text not null,
	body text not null
);

create unique index prediction_id_uindex
	on prediction (id);

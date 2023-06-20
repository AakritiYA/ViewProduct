SELECT *
FROM product
join category on product.category_id=category.id
WHERE title = 'Shirt' AND category_id=1;

output:-
price, id, description, title, category_id, id, name
'1000','3','product','shirt','1','1','Clothing'
'600','5','product','Shirt','1','1','Clothing'

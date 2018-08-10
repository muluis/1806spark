SELECT * FROM album a
LEFT  JOIN artist  b
On a.artistid = b.artistid
LEFT JOIN track t
ON a.artistid = b.artistid
LEFT JOIN playlisttrack pt
ON pt.trackid = t.trackid
LEFT JOIN playlist p  
ON p.playlistid = pt.playlistid
LEFT JOIN invoiceline il
ON t.trackid = il.trackid
LEFT JOIN invoice i
ON il.invoiceid = i.invoiceid
LEFT JOIN mediatype m
ON t.mediatypeid = m.mediatypeid
LEFT JOIN genre g
ON t.genreid = g.genreid
LEFT JOIN customer c
ON i.customerid  = c.customerid
LEFT JOIN employee e
ON c.supportrepid = e.employeeid;

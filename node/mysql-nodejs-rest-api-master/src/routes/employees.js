const express = require('express');
const router = express.Router();

const mysqlConnection  = require('../database.js');

// GET all Employees
router.get('/', (req, res) => {
  mysqlConnection.query('SELECT * FROM musuarios', (err, rows, fields) => {
    if(!err) {
      res.json(rows);
    } else {
      console.log(err);
    }
  });  
});

// GET An Employee
router.get('/:id', (req, res) => {
  const { id } = req.params; 
  mysqlConnection.query('SELECT * FROM musuarios WHERE id_usu = ?', [id], (err, rows, fields) => {
    if (!err) {
      if(rows.length > 0){
        res.json(rows[0]);
      }else{
        res.json({status: 'Employeed not'});
      }  

      
    } else {
      console.log(err);
      res.json({status: 'Employeed not'});
      console.log('error');
    }
  });
});

// DELETE An Employee
router.delete('/:id', (req, res) => {
  const { id } = req.params;
  mysqlConnection.query('DELETE FROM musuarios WHERE id_usu = ?', [id], (err, rows, fields) => {
    if(!err) {
      res.json({status: 'Employee Deleted'});
    } else {
      console.log(err);
    }
  });
});

// INSERT An Employee
router.post('/', (req, res) => {
  const {id, name, pas} = req.body;
  console.log(id, name, pas);
  const query = `
    SET @id_usu = ?;
    SET @nom_usu = ?;
    SET @contraseña_usu = ?;
    CALL employeeAddOrEdit(@id_usu, @nom_usu, @contraseña_usu);
  `;
  mysqlConnection.query(query, [id, name, pas], (err, rows, fields) => {
    if(!err) {
      res.json({status: 'Employeed Saved'});
    } else {
      res.json({status: 'Employeed not'});
      console.log(err);
    }
  });

});

router.put('/:id', (req, res) => {
  const { name, pas } = req.body;
  const { id } = req.params;
  const query = `
    SET @id = ?;
    SET @name = ?;
    SET @pas = ?;
    CALL employeeAddOrEdit(@id, @name, @pas);
  `;
  mysqlConnection.query(query, [id, name, pas], (err, rows, fields) => {
    if(!err) {
      res.json({status: 'Employee Updated'});
    } else {
      console.log(err);
    }
  });
});

router.post('/Inicio', (req, res)=> {
  const { name, pas } = req.body;
  mysqlConnection.query('select * from musuarios where nom_usu = ? and contraseña_usu = ?', [name, pas], (err, rows) => {
  if(!err){
    if(rows.length > 0){
      res.json({
        status: 'Employee founded',
        usuario: rows[0]
      })
    }else{
      res.json({
        status: 'no encontrado'
      })
    }
  }else{
    console.error(err)
    res.json({
      status: 'error'
    })
  }
  })
})
module.exports = router;

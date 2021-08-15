var express = require('express');
var router = express.Router();

const {
  users_list,
  users_create,
  users_update_one,
  users_delete_one,
  users_get_one
} = require('../controllers/usersController');

const { check, validationResult } = require('express-validator/check');

// Validation rules
const valid_user = [
    check('name', 'El nombre debe tener mínimo 3 caracteres y no puede incluir ningún número')
      .isLength({ min: 3 })
      .isAlpha(locale = 'es-ES', { ignore: '- /' }),
    check('surnames', 'Los apellidos deben tener mínimo 3 caracteres y no pueden incluir ningún número')
      .isLength({ min: 3 })
      .isAlpha(locale = 'es-ES', { ignore: '- /' }),
    check('age', 'La edad debe ser un valor entre 0 y 125')
      .isFloat({ min: 0, max: 125 }),
    check('dni', 'El DNI debe contener 9 caracteres alfanuméricos')
      .isLength({ min: 9, max: 9 })
      .isAlphanumeric(),
    check('birthday', 'El cumpleaños debe estar en formato aaaa-mm-dd')
      .isISO8601(),
    check('favouriteColour', 'El color favorito debe tener mínimo 3 caracteres y no puede incluir ningún número')
      .isLength({ min: 3 })
      .isAlpha(locale = 'es-ES', { ignore: '- /' }),
    check('gender', 'El género debe ser uno de los siguientes: Hombre, Mujer, Otro, y No especificado')
      .isIn(['Hombre', 'Mujer', 'Otro', 'No especificado']),
    onErrorAbort
];

// GET users listing.
router.get('/', users_list);

// GET user.
router.get('/:id', users_get_one);

// POST create user.
router.post('/', valid_user, users_create);

// PUT update user.
router.put('/:id', valid_user, users_update_one);

// DELETE delete user.
router.delete('/:id', users_delete_one);

// Aborting requests validation errors
function  onErrorAbort(req, res, next){
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }
    next();
}

module.exports = router;

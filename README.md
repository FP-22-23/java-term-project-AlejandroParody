
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 22/23)

Autor/a: Alejandro Parody Quirós 

UVUS: DPC6046

In this project we will work with a dataset with information of the different spells from the fantasy tabletop role-playing game named Dungeons and Dragons (DnD or D&D for short).

The original dataset has been obtained from the following kaggle link:

https://www.kaggle.com/datasets/mrpantherson/dndspells

The original dataset presents some problems like the fact that we lack some properties like LocalDate. This is why I have chosen to add some new columns or delete others that were not necessary.

## Project's folder structure

* /src: Contains the different packages that are part of the project:
    * fp.dnd_spells: Package that contains the types of the project.
    * fp.spells.test: In this package we can find the classes needed to check if the project works correctly.
    * fp.auxi: Package where we have the auxiliary types.
    * fp.utils: Package where we have the utils classes.
    
* /data: Contains the dataset of the project.
    * dnd_spells.csv: Dataset with the information of the spells from the game.


## Dataset Structure

Every line of the dataset includes the information of a different spell of Dungeons and Dragons,  and for every spell we have the following information:

* Name : Of String type, in this column we have the name of the spell.

* Classes : Of ArrayList type, in this column we have a list of the different classes that can use the spell.

* school : Of Enum type, it represents to what school of magic the spell belongs to.

* cast_time : Of Enum type, it represents how long it takes to cast the spell in game.

* range : Of Double type, it represents the distance in meters that the spell can reach.

* Duration : Of String type, it means the time the spell remains after been cast.

* verbal : Of Boolean type, it represents the need to speak or not to be able to cast the spell.

* somatic : Of Boolean type, it represents the need to be in touch with the objective of the spell to cast it.

* material : Of Boolean type, a derived type from mat_cost, it represents if the spell needs a material to be cast.

* mat_cost : Of String type, in the case the spell needs a material to cast it, here we have the material/s needed.

* date : Of LocalDate type, it's the date in which the book where the spell first appeared was released.

* year : Of Integer type, a derived type from the date, it's the year the spell was implemented.

* Description: Of String type, an explanation of what the spell does in-game.

## Implemented types

### Factory:

### Container type:

### Constructors:

### Constrains:

### Criterion of equality: 

### Criterion of natural order: 

### Other operations:



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
        * Spell.java : The Base type of this project.
        * SpellFactory.java : The Factory for the Spell type.
        * SpellContainer.vjava : The Container type for Spell.java.
    * fp.spells.test: In this package we can find the types needed to check if the project works correctly.
        * Spell_test.java : In this type we find the tests done to the Spell type.
        * SpellFactory_Test.java : In this type we find the tests done to the SpellFactory type.
        * SpellContainer_test.java : In this type we find the tests done to the SpellContainer type.
    * fp.auxi: Package where we have the auxiliary types.
        * Ctime.java : Type for the Enum type cast_time.
        * School.java : Type for the Enum type of school.
        * Spelltype.java : Type for the auxiliary type Spelltype.
    * fp.utils: Package where we have Checkers type.
    
* /data: Contains the dataset of the project.
    * dnd_spells.csv: Dataset with the information of the spells from the game.

## Dataset Structure

The dataset used for this project has 10 columns, modified from the 12 columns it had originally. This 10 columns are as follows:

* name : String, it indicates the name of the spell.

* classes : String, it represents the different Dnd classes that can use the spell.
 
* school : String, it contains the school of magic the spell is from. For example all the spells that summon an entity of any type are from the school of Conjuration.

* cast_time : String, in game terms, every act you do needs a certain time to take effect, it can go from a full combat turn, to some that takes hours.

* range : Double, the maximum distance at which you can cast the spell.

* duration : String, certain spells leave an effect after being cast, this column contains for how long does that effect stays active.

* material_cost : String, this column includes any material requirement to cast the spell if there is any.
 
* verbal : Boolean, it contains a 1 in the case that to cast the spell the character is needed to do some talk of any type, and a zero if it doesn't.

* somatic : Boolean, it contains a 1 in the case that to cast the spell the character is needed to do some kind of gesture, and a zero if it doesn't.

* date : LocalDate, it represents the date the spell was released, either by an official book or by a latter patch.

## Implemented types

### Base type - Spell:

Every line of the dataset represents the information of a different spell of Dungeons and Dragons,  and for every spell we have the following information:

* Name : Of String type, in this column we have the name of the spell.

* Classes : Of ArrayList<String> type, in this column we have a list of the different classes that can use the spell.

* school : Of Enum type, it represents to what school of magic the spell belongs to. It can take the values NECROMANCY, ABJURATION, CONJURATION, EVOCATION, TRANSMUTATION, ENCHANTMENT, DIVINATION, ILLUSION or OTHER.

* cast_time : Of Enum type, it represents how long it takes to cast the spell in game. It can take the values ACTION, BONUS, REACTION or OTHER.

* range : Of Double type, it represents the distance in meters that the spell can reach.

* Duration : Of String type, it means the time the spell remains after been cast.

* mat_cost : Of String type, in the case the spell needs a material to cast it, here we have the material/s needed.

* material : Of Boolean type, a derived type from mat_cost, it represents if the spell needs a material to be cast.

* type : Of Auxiliary type, an auxiliar type that is comprised of two boolean and a String derived from them that represents if the spell needs either a somatic or a verbal component (to recite some words or to do some gestures to cast the spell).

* date : Of LocalDate type, it's the date in which the book where the spell first appeared was released.

* year : Of Integer type, a derived type from the date, it's the year the spell was implemented.

#### Constructors:

* C1: It creates a Spell from a parameter String (the name of the spell), a parameter School (the the school where it belongs), and a Spelltype.

* C2: It recieves a value for each parameter of the base type.

#### Restrictions:

* R1: The range of the spell has to be equal or over zero.

* R2: The spell requires a name, it can't be neither an empty string nor null.

* R3: The date of creation needs to be either today or before.

#### Criterions:

* Criterion of equality: Two spells are equal if all their basic properties are equal.

* Criterion of natural order: By name first and then by school.

### Factory - SpellFactory:

Factory class to build objects inside the SpellContainer type.

* readFilefromPath: It receives as a parameter a string containing the name and path of the CSV file, and returns a set of spell.
 
* readFileStream: It receives as a parameter a string containing the name and path of the CSV file, and returns an object of type SpellContainer.

* ParseSpell: It receives as a parameter a string formatted as the lines of the CSV file, and returns a Spell from that String.

### Container type - SpellContainer:

Container class of the objects of type Spell.

* SpellContainer, of Set<Spell> type. It's the set made from a group of the basic type Spell.

#### Constructors:

* C1: Default constructor, it creates an object with no Spell in it.

* C2: Constructor from a Set<Spell>, it creates an object with the spells from the set.

* C3: Constructor from stream, it creates an object with the spells from the stream.

#### Operations:

##### |Delivery 2|

* getNumItems() : This operation returns the number of items contained in the specified container.
 
* additem(Spell s) : This operation adds the spell introduced in the parenthesis into the specified container. 

* delItem(Spell s) : This operation deletes the spell introduced in the parenthesis from the specified container.

* addColl(Set<Spell> c) : This operation adds the whole set introduced into the specified container.

#### Methods:

##### |Delivery 2|

* SpellCheck(String n) : This method checks if it exists a spell in the container with the name introduced (it exists).

* NumSpells(String c) : This method requires the name of a DnD class, and returns the number of spells this class can cast from the container (counter).

* ClassSpells(String c) : This method returns a set with the spells that can be casted by the DnD class introduced (selection with filtering).

* SpellsbyClass() : This method creates a set of classes, add it as keys for the map and then adds the spell to each class that can use it (grouping method that returns a Set).

* ClassNumSpells() : This method creates a set of classes, add it as keys for the map and then counts in how many spells it's contained (grouping method that counts).

##### |Delivery 3|

* SpellCheckST(String n) : This method checks if it exists a spell in the container with the name introduced using streams(it exists).

* NumSpellsST(String c) : This method requires the name of a DnD class, and returns the number of spells this class can cast from the container using streams(counter).

* ClassSpellsST(String c) : This method returns a set with the spells that can be casted by the DnD class introduced using streams(selection with filtering).

* SpellMaxRangebyClass(String c) : This method takes the Stream and gets the spell with the maximum range, after filtering to get only the ones that contain the DnD class introduced.

* SpellsbyClassSortedbyRange(String c) : This method returns a set of the spells that can be cast by the class introduced sorted by it's range in natural order.

* SpellbyDatesST() : This method creates a set of dates, add it as keys for the map and then add the spells that released in that date.

* NSpellsbyDate() : This method returns a map where the release dates are the keys and as values it has a set made of the spells that released in that date.

* SpellMaxRangeBySchool() : This method returns a map where the keys are the different schools of magic, and as values each has the corresponding spell to that class that has the maximum range.

* SpellsMostRangeBySchool(Integer n) : This method recieves an integer number, and returns a SortedMap where the keys are the different schools of magic and the values are the n spells that have the most range from each school.

* ClassCuantitySpells(String s) : This method creates a map where the keys are the different DnD classes, the values are the set of spells that can be casted by each, and it recieves a string that dictates if the result is the key with largest of the smallest number of them.

#### Others:

* Criterion of equality.

* toString method.


create or replace package ManyServices is

type ManyInfo is record (
  id number,
  clss number,
  entryId number
);

type ManyInfoCollection is ref cursor return ManyInfo;

type IndexedInfo is record (
  clss number,
  entryId number
);

type IndexedInfoCollection is ref cursor return IndexedInfo;

end;
/